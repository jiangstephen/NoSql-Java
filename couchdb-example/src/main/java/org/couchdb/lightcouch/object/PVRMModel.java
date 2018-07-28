package org.couchdb.lightcouch.object;

import org.couchdb.lightcouch.object.enums.BusinessUnit;

public class PVRMModel extends Model {

	private String modelOwner;
	
	public PVRMModel(String name, String description, BusinessUnit businessUnit, String modelOwner) {
		super(name, description, businessUnit);
		this.modelOwner = modelOwner;
	}

	public String getModelOwner() {
		return modelOwner;
	}

	public void setModelOwner(String modelOwner) {
		this.modelOwner = modelOwner;
	}
	
}
