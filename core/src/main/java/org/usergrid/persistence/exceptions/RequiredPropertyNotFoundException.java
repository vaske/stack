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
package org.usergrid.persistence.exceptions;

public class RequiredPropertyNotFoundException extends PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String entityType;
	final String propertyName;

	public RequiredPropertyNotFoundException(String entityType,
			String propertyName) {
		super("Entity " + entityType + " requires a property named "
				+ propertyName);
		this.entityType = entityType;
		this.propertyName = propertyName;
	}

	public String getEntityType() {
		return entityType;
	}

	public String getPropertyName() {
		return propertyName;
	}
}
