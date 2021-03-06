/*******************************************************************************
 * Copyright (c) 2010, 2011 Ed Anuff and Usergrid, all rights reserved.
 * http://www.usergrid.com
 * 
 * This file is part of Usergrid Core.
 * 
 * Usergrid Core is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Usergrid Core is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Usergrid Core. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.usergrid.persistence.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.usergrid.persistence.TypedEntity;
import org.usergrid.persistence.annotations.EntityCollection;
import org.usergrid.persistence.annotations.EntityDictionary;
import org.usergrid.persistence.annotations.EntityProperty;

/**
 * The User entity class for representing users in the service.
 */
@XmlRootElement
public class User extends TypedEntity {

	public static final String ENTITY_TYPE = "user";

	public static final String CONNECTION_FOLLOW = "follow";

	@EntityProperty(indexed = true, fulltextIndexed = false, required = true, indexedInConnections = true, aliasProperty = true, unique = true, basic = true)
	protected String username;

	@EntityProperty(indexed = true, unique = true, basic = true)
	protected String email;

	@EntityProperty(indexed = true)
	protected String name;

	@EntityProperty(indexed = false)
	protected Boolean activated;

	@EntityProperty(indexed = false)
	protected Boolean disabled;

	@EntityProperty(indexed = true)
	protected String firstname;

	@EntityProperty(indexed = true)
	protected String middlename;

	@EntityProperty(indexed = true)
	protected String lastname;

	@EntityDictionary(keyType = java.lang.String.class)
	protected Set<String> connections;

	@EntityDictionary(keyType = java.lang.String.class, valueType = java.lang.String.class)
	protected Map<String, String> rolenames;

	@EntityDictionary(keyType = java.lang.String.class)
	protected Set<String> permissions;

	@EntityDictionary(keyType = java.lang.String.class, valueType = java.lang.String.class)
	protected Map<String, String> credentials;

	@EntityCollection(type = "group", linkedCollection = "users", propertiesIndexed = { "path" }, indexingDynamicProperties = true)
	protected List<UUID> groups;

	@EntityCollection(type = "activity", propertiesIndexed = { "created",
			"published", "content" }, subkeys = { "verb" }, reversed = true, sort = "published desc")
	protected List<UUID> activities;

	@EntityCollection(type = "activity", propertiesIndexed = { "created",
			"published", "content" }, subkeys = { "verb" }, reversed = true, sort = "published desc")
	protected List<UUID> feed;

	@EntityCollection(type = "role")
	protected List<UUID> roles;

	public User() {
		// id = UUIDUtils.newTimeUUID();
	}

	public User(UUID id) {
		uuid = id;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean activated() {
		return (activated != null) && activated;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public boolean disabled() {
		return (disabled != null) && disabled;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public List<UUID> getGroups() {
		return groups;
	}

	public void setGroups(List<UUID> groups) {
		this.groups = groups;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Set<String> getConnections() {
		return connections;
	}

	public void setConnections(Set<String> connections) {
		this.connections = connections;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Map<String, String> getRolenames() {
		return rolenames;
	}

	public void setRolenames(Map<String, String> rolenames) {
		this.rolenames = rolenames;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public Map<String, String> getCredentials() {
		return credentials;
	}

	public void setCredentials(Map<String, String> credentials) {
		this.credentials = credentials;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public List<UUID> getActivities() {
		return activities;
	}

	public void setActivities(List<UUID> activities) {
		this.activities = activities;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public List<UUID> getFeed() {
		return feed;
	}

	public void setFeed(List<UUID> feed) {
		this.feed = feed;
	}

	@JsonSerialize(include = Inclusion.NON_NULL)
	public List<UUID> getRoles() {
		return roles;
	}

	public void setRoles(List<UUID> roles) {
		this.roles = roles;
	}

}
