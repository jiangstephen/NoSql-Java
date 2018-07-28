package org.couchdb.lightcouch.object;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;

public abstract class CouchDBObject {
	
	private String clazz = this.getClass().getName();
	
	@SerializedName("_id")
	private String id;
	
	@SerializedName("_rev")
	private String revision;

	private Boolean active = true;
	
	private Date creationDate = new Date();
	
	private Date updateDate = new Date();

	abstract public String getTableName();

	public void setTableName(String tableName) {
		if(!StringUtils.equals(tableName, getTableName())){
			throw new IllegalArgumentException("table name doesn't match " + getTableName());
		}
	}
	
	public String getClassType(){
		return clazz;
	}
	
	public void setClassType(String clazz){
		if(!this.clazz.equals(clazz)){
			throw new IllegalArgumentException();
		}
		this.clazz = clazz;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
}
