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

import static org.usergrid.utils.ClassUtils.cast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.usergrid.persistence.Entity;
import org.usergrid.persistence.EntityRef;
import org.usergrid.persistence.Query;
import org.usergrid.persistence.Results;
import org.usergrid.persistence.Results.Level;
import org.usergrid.persistence.Schema;
import org.usergrid.services.ServiceResults.Type;
import org.usergrid.services.exceptions.ServiceResourceNotFoundException;

public class AbstractCollectionService extends AbstractService {

	private static final Logger logger = Logger
			.getLogger(AbstractCollectionService.class);

	public AbstractCollectionService() {
		// addSet("indexes");
		addMetadataType("indexes");
	}

	// cname/id/

	@Override
	public ServiceResults getItemById(ServiceContext context, UUID id)
			throws Exception {

		EntityRef entity = null;

		if (!context.moreParameters()) {
			entity = em.get(id);

			entity = importEntity(context, (Entity) entity);
		} else {
			entity = em.getRef(id);
		}

		if (entity == null) {
			throw new ServiceResourceNotFoundException(context);
		}

		// TODO check that entity is in fact in the collection

		List<ServiceRequest> nextRequests = context
				.getNextServiceRequests(entity);

		return new ServiceResults(this, context, Type.COLLECTION,
				Results.fromRef(entity), null, nextRequests);
	}

	@Override
	public ServiceResults getItemByName(ServiceContext context, String name)
			throws Exception {

		String nameProperty = Schema.getDefaultSchema().aliasProperty(
				getEntityType());
		if (nameProperty == null) {
			nameProperty = "name";
		}

		EntityRef entity = em.getAlias(getEntityType(), name);
		if (entity == null) {
			throw new ServiceResourceNotFoundException(context);
		}

		if (!context.moreParameters()) {
			entity = em.get(entity);
			entity = importEntity(context, (Entity) entity);
		}

		/*
		 * Results.Level level = Results.Level.REFS; if (isEmpty(parameters)) {
		 * level = Results.Level.ALL_PROPERTIES; }
		 * 
		 * Results results = em.searchCollectionForProperty(owner,
		 * getCollectionName(), null, nameProperty, name, null, null, 1, level);
		 * EntityRef entity = results.getRef();
		 */

		List<ServiceRequest> nextRequests = context
				.getNextServiceRequests(entity);

		return new ServiceResults(this, context, Type.COLLECTION,
				Results.fromRef(entity), null, nextRequests);
	}

	@Override
	public ServiceResults getItemsByQuery(ServiceContext context, Query query)
			throws Exception {

		int count = 1;
		Results.Level level = Results.Level.REFS;

		if (!context.moreParameters()) {
			count = 0;
			level = Results.Level.ALL_PROPERTIES;
		}

		if (context.getRequest().isReturnsTree()) {
			level = Results.Level.ALL_PROPERTIES;
		}

		query = new Query(query);
		query.setResultsLevel(level);
		query.setLimit(query.getLimit(count));
		if (!query.isReversedSet()) {
			query.setReversed(isCollectionReversed(context));
		}
		query.addSort(getCollectionSort(context));
		/*
		 * if (count > 0) { query.setMaxResults(count); }
		 */

		Results r = em.searchCollection(context.getOwner(),
				context.getCollectionName(), query);

		List<ServiceRequest> nextRequests = null;
		if (!r.isEmpty()) {

			if (!context.moreParameters()) {
				importEntities(context, r);
			}

			nextRequests = context.getNextServiceRequests(r.getRefs());
		}

		return new ServiceResults(this, context, Type.COLLECTION, r, null,
				nextRequests);
	}

	@Override
	public ServiceResults getCollection(ServiceContext context)
			throws Exception {

		if (getCollectionSort(context) != null) {
			return getItemsByQuery(context, new Query());
		}

		int count = 10;
		Results r = em.getCollection(context.getOwner(),
				context.getCollectionName(), null, count, Level.ALL_PROPERTIES,
				isCollectionReversed(context));

		importEntities(context, r);

		/*
		 * if (r.isEmpty()) { throw new
		 * ServiceResourceNotFoundException(request); }
		 */

		return new ServiceResults(this, context, Type.COLLECTION, r, null, null);
	}

	@Override
	public ServiceResults putItemById(ServiceContext context, UUID id)
			throws Exception {

		if (context.moreParameters()) {
			return getItemById(context, id);
		}

		Entity item = em.get(id);
		updateEntity(context, item, context.getPayload());
		item = importEntity(context, item);

		return new ServiceResults(this, context, Type.COLLECTION,
				Results.fromEntity(item), null, null);
	}

	@Override
	public ServiceResults putItemByName(ServiceContext context, String name)
			throws Exception {

		if (context.moreParameters()) {
			return getItemByName(context, name);
		}

		EntityRef ref = em.getAlias(getEntityType(), name);
		if (ref == null) {
			throw new ServiceResourceNotFoundException(context);
		}
		Entity entity = em.get(ref);
		entity = importEntity(context, entity);

		updateEntity(context, entity);

		return new ServiceResults(this, context, Type.COLLECTION,
				Results.fromEntity(entity), null, null);

	}

	@Override
	public ServiceResults putItemsByQuery(ServiceContext context, Query query)
			throws Exception {

		if (context.moreParameters()) {
			return getItemsByQuery(context, query);
		}

		query = new Query(query);
		query.setResultsLevel(Level.ALL_PROPERTIES);
		query.setLimit(1000);
		if (!query.isReversedSet()) {
			query.setReversed(isCollectionReversed(context));
		}
		query.addSort(getCollectionSort(context));

		Results r = em.searchCollection(context.getOwner(),
				context.getCollectionName(), query);
		if (r.isEmpty()) {
			throw new ServiceResourceNotFoundException(context);
		}

		updateEntities(context, r);

		return new ServiceResults(this, context, Type.COLLECTION, r, null, null);
	}

	@Override
	public ServiceResults postCollection(ServiceContext context)
			throws Exception {

		if (context.getPayload().isBatch()) {
			List<Entity> entities = new ArrayList<Entity>();
			List<Map<String, Object>> batch = context.getPayload()
					.getBatchProperties();
			logger.info("Attempting to batch create " + batch.size()
					+ " entities in collection " + context.getCollectionName());
			int i = 1;
			for (Map<String, Object> p : batch) {
				logger.info("Creating entity " + i + " in collection "
						+ context.getCollectionName());

				Entity item = null;

				try {
					item = em.createItemInCollection(context.getOwner(),
							context.getCollectionName(), getEntityType(), p);
				} catch (Exception e) {
					logger.info("Entity " + i + " created in collection "
							+ context.getCollectionName() + " with UUID "
							+ item.getUuid());
				}

				item = importEntity(context, item);
				entities.add(item);
				i++;
			}
			return new ServiceResults(this, context, Type.COLLECTION,
					Results.fromEntities(entities), null, null);
		}

		Entity item = em.createItemInCollection(context.getOwner(),
				context.getCollectionName(), getEntityType(),
				context.getProperties());

		item = importEntity(context, item);

		return new ServiceResults(this, context, Type.COLLECTION,
				Results.fromEntity(item), null, null);

	}

	@Override
	public ServiceResults postItemsByQuery(ServiceContext context, Query query)
			throws Exception {
		if (context.moreParameters()) {
			return super.postItemsByQuery(context, query);
		}
		return postCollection(context);
	}

	@Override
	public ServiceResults postItemById(ServiceContext context, UUID id)
			throws Exception {

		if (context.moreParameters()) {
			return getItemById(context, id);
		}

		Entity entity = em.get(id);
		if (entity == null) {
			return null;
		}
		entity = importEntity(context, entity);

		em.addToCollection(context.getOwner(), context.getCollectionName(),
				entity);

		return new ServiceResults(null, context, Type.CONNECTION,
				Results.fromEntity(entity), null, null);
	}

	@Override
	public ServiceResults postItemByName(ServiceContext context, String name)
			throws Exception {

		if (context.moreParameters()) {
			return super.postItemByName(context, name);
		}

		EntityRef ref = em.getAlias(getEntityType(), name);
		if (ref == null) {
			throw new ServiceResourceNotFoundException(context);
		}

		return postItemById(context, ref.getUuid());
	}

	@Override
	public ServiceResults deleteItemById(ServiceContext context, UUID id)
			throws Exception {

		if (context.moreParameters()) {
			return getItemById(context, id);
		}

		Entity item = em.get(id);
		item = importEntity(context, item);

		em.removeFromCollection(context.getOwner(),
				context.getCollectionName(), item);

		return new ServiceResults(this, context, Type.COLLECTION,
				Results.fromEntity(item), null, null);

	}

	@Override
	public ServiceResults deleteItemByName(ServiceContext context, String name)
			throws Exception {

		if (context.moreParameters()) {
			return getItemByName(context, name);
		}

		EntityRef ref = em.getAlias(getEntityType(), name);
		if (ref == null) {
			throw new ServiceResourceNotFoundException(context);
		}
		Entity entity = em.get(ref);
		entity = importEntity(context, entity);

		em.removeFromCollection(context.getOwner(),
				context.getCollectionName(), entity);

		return new ServiceResults(this, context, Type.COLLECTION,
				Results.fromEntity(entity), null, null);

	}

	@Override
	public ServiceResults deleteItemsByQuery(ServiceContext context, Query query)
			throws Exception {

		if (context.moreParameters()) {
			return getItemsByQuery(context, query);
		}

		query = new Query(query);
		query.setResultsLevel(Level.ALL_PROPERTIES);
		query.setLimit(1000);
		if (!query.isReversedSet()) {
			query.setReversed(isCollectionReversed(context));
		}
		query.addSort(getCollectionSort(context));

		Results r = em.searchCollection(context.getOwner(),
				context.getCollectionName(), query);
		if (r.isEmpty()) {
			throw new ServiceResourceNotFoundException(context);
		}

		importEntities(context, r);

		for (Entity entity : r) {
			em.removeFromCollection(context.getOwner(),
					context.getCollectionName(), entity);
		}

		return new ServiceResults(this, context, Type.COLLECTION, r, null, null);
	}

	@Override
	public ServiceResults getServiceMetadata(ServiceContext context,
			String metadataType) throws Exception {

		if ("indexes".equals(metadataType)) {
			Set<String> indexes = cast(em.getCollectionIndexes(
					context.getOwner(), context.getCollectionName()));

			return new ServiceResults(this, context.getRequest().withPath(
					context.getRequest().getPath() + "/indexes"),
					context.getPreviousResults(), context.getChildPath(),
					Type.GENERIC, Results.fromData(indexes), null, null);
		}
		return null;

	}

}
