package org.couchdb.lightcouch.object;

import org.couchdb.lightcouch.object.enums.BusinessUnit;

public class GenericModel extends Model {

	private int positionCount;
	
	public GenericModel(String name, String description, BusinessUnit businessUnit, int positionCount) {
		super(name, description, businessUnit);
		this.positionCount = positionCount;
	}

	public int getPositionCount() {
		return positionCount;
	}

	public void setPositionCount(int positionCount) {
		this.positionCount = positionCount;
	}
	
}
