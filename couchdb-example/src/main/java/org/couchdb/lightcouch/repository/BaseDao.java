package org.couchdb.lightcouch.repository;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

import org.couchdb.lightcouch.object.CouchDBObject;
import org.lightcouch.CouchDbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDao <T extends CouchDBObject> {
	
	protected Class<T> persistentClass;
	
	@Autowired
	protected CouchDbClient couchDbClient;
	

	@SuppressWarnings("unchecked")
	public BaseDao() {
	    this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void add(T object){
		couchDbClient.save(object);
	}

	public void remove(T doc){
		couchDbClient.remove(doc);
	}
	
	public void findOne(String id){
		couchDbClient.find(persistentClass, id);
	}
	
	public void update(T doc){
		doc.setUpdateDate(new Date());
		couchDbClient.update(doc);
	}
	
}
