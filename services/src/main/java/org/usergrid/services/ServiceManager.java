/*******************************************************************************
 * Copyright (c) 2010, 2011 Ed Anuff and Usergrid, all rights reserved.
 * http://www.usergrid.com
 * 
 * This file is part of Usergrid Stack.
 * 
 * Usergrid Stack is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * Usergrid Stack is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License along
 * with Usergrid Stack. If not, see <http://www.gnu.org/licenses/>.
 * 
 * Additional permission under GNU AGPL version 3 section 7
 * 
 * Linking Usergrid Stack statically or dynamically with other modules is making
 * a combined work based on Usergrid Stack. Thus, the terms and conditions of the
 * GNU General Public License cover the whole combination.
 * 
 * In addition, as a special exception, the copyright holders of Usergrid Stack
 * give you permission to combine Usergrid Stack with free software programs or
 * libraries that are released under the GNU LGPL and with independent modules
 * that communicate with Usergrid Stack solely through:
 * 
 *   - Classes implementing the org.usergrid.services.Service interface
 *   - Apache Shiro Realms and Filters
 *   - Servlet Filters and JAX-RS/Jersey Filters
 * 
 * You may copy and distribute such a system following the terms of the GNU AGPL
 * for Usergrid Stack and the licenses of the other code concerned, provided that
 ******************************************************************************/
package org.usergrid.services;

import static org.usergrid.persistence.SimpleEntityRef.ref;
import static org.usergrid.utils.InflectionUtils.pluralize;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.usergrid.persistence.Entity;
import org.usergrid.persistence.EntityManager;
import org.usergrid.persistence.EntityRef;
import org.usergrid.persistence.entities.Application;
import org.usergrid.services.ServiceParameter.IdParameter;
import org.usergrid.services.applications.ApplicationsService;
import org.usergrid.services.exceptions.UndefinedServiceEntityTypeException;
import org.usergrid.utils.ListUtils;

public class ServiceManager {

	// because one typo can ruin your whole day
	public static final String ENTITY = "entity";
	public static final String ENTITY_SUFFIX = "." + ENTITY;
	public static final String COLLECTION = "collection";
	public static final String COLLECTION_SUFFIX = "." + COLLECTION;
	public static final String OSS_PACKAGE_PREFIX = "org.usergrid.services";
	public static final String COM_PACKAGE_PREFIX = "com.usergrid.services";

	private static final Logger logger = Logger.getLogger(ServiceManager.class);

	UUID applicationId;

	EntityManager em;

	ServiceManagerFactory smf;

	// search for commercial packages first for SaaS version
	public static String[] package_prefixes = { COM_PACKAGE_PREFIX,
			OSS_PACKAGE_PREFIX };

	boolean searchPython;

	public ServiceManager(ServiceManagerFactory smf, EntityManager em) {
		this.smf = smf;
		this.em = em;
		if (em != null) {
			applicationId = em.getApplicationRef().getUuid();
		}
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public UUID getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(UUID applicationId) {
		this.applicationId = applicationId;
	}

	public EntityRef getApplicationRef() {
		return ref(Application.ENTITY_TYPE, applicationId);
	}

	public Service getEntityService(String entityType) {
		String serviceType = "/" + pluralize(entityType);
		return getService(serviceType);
	}

	public Entity importEntity(ServiceRequest request, Entity entity)
			throws Exception {
		Service service = getEntityService(entity.getType());
		if (service != null) {
			return service.importEntity(request, entity);
		}
		return entity;
	}

	public Entity writeEntity(ServiceRequest request, Entity entity)
			throws Exception {
		Service service = getEntityService(entity.getType());
		if (service != null) {
			return service.writeEntity(request, entity);
		}
		return entity;
	}

	public Entity updateEntity(ServiceRequest request, EntityRef ref,
			ServicePayload payload) throws Exception {
		Service service = getEntityService(ref.getType());
		if (service != null) {
			return service.updateEntity(request, ref, payload);
		}
		return null;
	}

	public Service getService(String serviceType) {
		return getService(serviceType, true);
	}

	public Service getService(String serviceType, boolean fallback) {

		if (serviceType == null) {
			return null;
		}

		serviceType = ServiceInfo.normalizeServicePattern(serviceType);

		logger.info("Looking up service pattern: " + serviceType);

		ServiceInfo info = ServiceInfo.getServiceInfo(serviceType);

		if (info == null) {
			return null;
		}

		Service service = getServiceInstance(info);

		if (service != null) {
			logger.info("Returning service instance: " + service.getClass());
		}

		/*
		 * if ((service == null) && fallback) { for (String pattern :
		 * info.getPatterns()) { service = getService(pattern, false); if
		 * (service != null) { break; } } }
		 */

		if (service == null) {
			logger.info("Service " + serviceType + " not found");
		}

		return service;
	}

	@SuppressWarnings("unchecked")
	private Class<Service> findServiceClass(ServiceInfo info) {
		Class<Service> cls = null;
		for (String pattern : info.getPatterns()) {
			for (String prefix : package_prefixes) {
				try {
					String classname = prefix + "."
							+ ServiceInfo.getClassName(pattern);
					logger.info("Attempting to instantiate service class "
							+ classname);
					cls = (Class<Service>) Class.forName(classname);
					if (cls.isInterface()) {
						cls = (Class<Service>) Class
								.forName(classname + "Impl");
					}
					if ((cls != null)
							&& !Modifier.isAbstract(cls.getModifiers())) {
						return cls;
					}
				} catch (ClassNotFoundException e1) {
					// logger.info(e1.toString());
				}
			}
		}
		return null;
	}

	private Service getServiceInstance(ServiceInfo info) {

		Class<Service> cls = findServiceClass(info);
		if (cls != null) {
			Service s = null;
			try {
				try {
					s = cls.newInstance();
				} catch (Exception e) {
				}
				if (s == null) {
					try {
						String cname = cls.getName();
						s = (Service) Class.forName(cname + "Impl")
								.newInstance();
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
			}
			if (s instanceof AbstractService) {
				AbstractService as = ((AbstractService) s);
				as.setServiceManager(this);

				as.init(info);

			}
			if (s != null) {
				if (s.getEntityType() == null) {
					throw new UndefinedServiceEntityTypeException();
				}
			}
			return s;
		}

		return null;
	}

	public ServiceRequest newRequest(ServiceAction action,
			List<ServiceParameter> parameters) throws Exception {
		return newRequest(action, false, parameters, null);
	}

	public ServiceRequest newRequest(ServiceAction action,
			List<ServiceParameter> parameters, ServicePayload payload)
			throws Exception {
		return newRequest(action, false, parameters, payload);
	}

	private ServiceRequest getApplicationRequest(ServiceAction action,
			boolean returnsTree, List<ServiceParameter> parameters,
			ServicePayload payload) throws Exception {

		String serviceName = pluralize(Application.ENTITY_TYPE);
		ListUtils.requeue(parameters, new IdParameter(applicationId));
		return new ServiceRequest(this, action, serviceName, parameters,
				payload, returnsTree);
	}

	static ApplicationsService appService = new ApplicationsService();

	public ServiceRequest newRequest(ServiceAction action, boolean returnsTree,
			List<ServiceParameter> parameters, ServicePayload payload)
			throws Exception {

		if (em != null) {
			em.incrementAggregateCounters(null, null, null,
					"application.requests", 1);

			if (action != null) {
				em.incrementAggregateCounters(null, null, null,
						"application.requests."
								+ action.toString().toLowerCase(), 1);
			}
		}

		if (!ServiceParameter.moreParameters(parameters)) {
			return getApplicationRequest(action, returnsTree, parameters,
					payload);
		}

		if (!ServiceParameter.firstParameterIsName(parameters)) {
			return null;
		}

		String nameParam = ServiceParameter.firstParameter(parameters)
				.getName();
		if (appService.hasEntityCommand(nameParam)
				|| appService.hasEntityDictionary(nameParam)) {
			return getApplicationRequest(action, returnsTree, parameters,
					payload);
		}

		String serviceName = ServiceParameter.dequeueParameter(parameters)
				.getName();
		return new ServiceRequest(this, action, serviceName, parameters,
				payload, returnsTree);
	}

	public void notifyExecutionEventListeners(ServiceAction action,
			ServiceRequest request, ServiceResults results,
			ServicePayload payload) {
		smf.notifyExecutionEventListeners(action, request, results, payload);
	}

	public void notifyCollectionEventListeners(String path,
			ServiceResults results) {
		smf.notifyCollectionEventListeners(path, results);
	}

}
