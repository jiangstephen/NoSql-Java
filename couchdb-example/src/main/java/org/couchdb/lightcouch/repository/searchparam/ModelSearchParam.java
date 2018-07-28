package org.couchdb.lightcouch.repository.searchparam;

import java.util.List;

import org.couchdb.lightcouch.object.enums.BusinessUnit;

public class ModelSearchParam {
	
	private String name;
	
	private String description;
	
	private List<BusinessUnit> businessUnitList;
	
	private boolean active = true; 
	
	private List<String> clazzList;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	public List<BusinessUnit> getBusinessUnitList() {
		return businessUnitList;
	}

	public void setBusinessUnitList(List<BusinessUnit> businessUnitList) {
		this.businessUnitList = businessUnitList;
	}

	public List<String> getClazzList() {
		return clazzList;
	}

	public void setClazzList(List<String> clazzList) {
		this.clazzList = clazzList;
	}

	public Object[] getStartKeys(){
		Object[] objs = new Object[4];
		
		return null;
	}
	
}
