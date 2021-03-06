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
package org.usergrid.rest.management;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.usergrid.utils.JsonUtils.mapToJsonString;
import static org.usergrid.utils.StringUtils.stringOrSubstringAfterFirst;
import static org.usergrid.utils.StringUtils.stringOrSubstringBeforeFirst;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.amber.oauth2.common.error.OAuthError;
import org.apache.amber.oauth2.common.exception.OAuthProblemException;
import org.apache.amber.oauth2.common.message.OAuthResponse;
import org.apache.amber.oauth2.common.message.types.GrantType;
import org.apache.log4j.Logger;
import org.apache.shiro.codec.Base64;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.usergrid.management.UserInfo;
import org.usergrid.rest.AbstractContextResource;
import org.usergrid.security.oauth.AccessInfo;

@Path("/management")
@Component
@Scope("singleton")
@Produces(APPLICATION_JSON)
public class ManagementResource extends AbstractContextResource {

	/*-
	 * New endpoints:
	 * 
	 * /management/organizations/<organization-name>/applications
	 * /management/organizations/<organization-name>/users
	 * /management/organizations/<organization-name>/keys
	 *
	 * /management/users/<user-name>/login
	 * /management/users/<user-name>/password
	 * 
	 */

	private static final Logger logger = Logger
			.getLogger(ManagementResource.class);

	public ManagementResource() {
		logger.info("ManagementResource initialized");
	}

	@GET
	@Path("token")
	public Response getAccessToken(@Context UriInfo ui,
			@HeaderParam("Authorization") String authorization,
			@QueryParam("grant_type") String grant_type,
			@QueryParam("username") String username,
			@QueryParam("password") String password,
			@QueryParam("client_id") String client_id,
			@QueryParam("client_secret") String client_secret) throws Exception {

		logger.info("ManagementResource.getAccessToken");

		UserInfo user = null;

		try {

			if (authorization != null) {
				String type = stringOrSubstringBeforeFirst(authorization, ' ')
						.toUpperCase();
				if ("BASIC".equals(type)) {
					String token = stringOrSubstringAfterFirst(authorization,
							' ');
					String[] values = Base64.decodeToString(token).split(":");
					if (values.length >= 2) {
						client_id = values[0].toLowerCase();
						client_secret = values[1];
					}
				}
			}

			// do checking for different grant types
			if (GrantType.PASSWORD.toString().equals(grant_type)) {
				try {
					user = management.verifyAdminUserPasswordCredentials(
							username, password);
				} catch (Exception e1) {
				}
			} else if ("client_credentials".equals(grant_type)) {
				try {
					AccessInfo access_info = management.authorizeClient(
							client_id, client_secret);
					if (access_info != null) {
						return Response.status(SC_OK)
								.type(APPLICATION_JSON_TYPE)
								.entity(mapToJsonString(access_info)).build();
					}
				} catch (Exception e1) {
				}
			}

			if (user == null) {
				OAuthResponse response = OAuthResponse
						.errorResponse(SC_BAD_REQUEST)
						.setError(OAuthError.TokenResponse.INVALID_GRANT)
						.setErrorDescription("invalid username or password")
						.buildJSONMessage();
				return Response.status(response.getResponseStatus())
						.type(APPLICATION_JSON_TYPE).entity(response.getBody())
						.build();
			}

			AccessInfo access_info = new AccessInfo()
					.withExpiresIn(3600)
					.withAccessToken(
							management.getAccessTokenForAdminUser(user
									.getUuid()))
					.withProperty(
							"user",
							management.getAdminUserOrganizationData(user
									.getUuid()));

			return Response.status(SC_OK).type(APPLICATION_JSON_TYPE)
					.entity(mapToJsonString(access_info)).build();

		} catch (OAuthProblemException e) {
			logger.error("OAuth Error", e);
			OAuthResponse res = OAuthResponse.errorResponse(SC_BAD_REQUEST)
					.error(e).buildJSONMessage();
			return Response.status(res.getResponseStatus())
					.type(APPLICATION_JSON_TYPE).entity(res.getBody()).build();
		}
	}

	@POST
	@Path("token")
	@Consumes(APPLICATION_FORM_URLENCODED)
	public Response getAccessTokenPost(@Context UriInfo ui,
			@FormParam("grant_type") String grant_type,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("client_id") String client_id,
			@FormParam("client_secret") String client_secret) throws Exception {

		logger.info("ManagementResource.getAccessTokenPost");

		return getAccessToken(ui, null, grant_type, username, password,
				client_id, client_secret);
	}
}
