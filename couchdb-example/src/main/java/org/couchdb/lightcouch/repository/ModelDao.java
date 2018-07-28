package org.couchdb.lightcouch.repository;

import java.util.List;

import org.couchdb.lightcouch.object.Model;
import org.couchdb.lightcouch.object.enums.BusinessUnit;
import org.couchdb.lightcouch.repository.searchparam.ModelSearchParam;
import org.springframework.stereotype.Repository;

@Repository
public class ModelDao extends BaseDao<Model> {
	
	private static final String MODEL_VIEW_NAME = "modelDesignDoc/_model_view";
	
	public List<? extends Model> searchByView(ModelSearchParam modelSearchParam){
		return couchDbClient.view(MODEL_VIEW_NAME)
				.startKey("org.couchdb.lightcouch.object.PVRMModel","ABC","AAA", "TECH")
				.endKey("org.couchdb.lightcouch.object.PVRMModel", "ABC", "AAA", "TECH")
				/*		modelSearchParam.getClazz(),
				modelSearchParam.getName(), 
				modelSearchParam.getDescription(), 
				BusinessUnit.ISG)*/
				.query(persistentClass);
	}
	
	public List<? extends Model> searchByJsonQuery(ModelSearchParam modelSearchParam){
		
		//couchDbClient.findDocs(jsonQuery, classOfT)
		return null;
	}

}
