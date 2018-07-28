package org.couchdb.lightcouch.object;

import org.couchdb.lightcouch.object.enums.BusinessUnit;

public class Model extends CouchDBObject {
	
	private static final String TABLE_NAME_MODEL = "MODEL";

	private String name;
	
	private String description;
	
	private BusinessUnit businessUnit;
	
	private String tableName = "MODEL";
	
	public Model(String name, String description,  BusinessUnit businessUnit){
		this.name = name;
		this.description = description;
		this.businessUnit = businessUnit;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BusinessUnit getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}


	@Override
	public String getTableName() {
		return TABLE_NAME_MODEL;
	}

}
