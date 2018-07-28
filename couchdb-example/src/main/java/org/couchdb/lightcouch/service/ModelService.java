package org.couchdb.lightcouch.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.couchdb.lightcouch.object.GenericModel;
import org.couchdb.lightcouch.object.Model;
import org.couchdb.lightcouch.object.PVRMModel;
import org.couchdb.lightcouch.object.enums.BusinessUnit;
import org.couchdb.lightcouch.repository.ModelDao;
import org.couchdb.lightcouch.repository.searchparam.ModelSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
	
	@Autowired
	private ModelDao modelDao;
	
	public <T extends Model> void  addModels(int count, Class<T> modelClass){
		for(int i = 0; i < count; i++){
			String name = RandomStringUtils.random(10, "ABCDEFG");
			String description  = RandomStringUtils.random(10, "ABCDEFG");
			BusinessUnit businessUnit = BusinessUnit.values()[RandomUtils.nextInt(0, BusinessUnit.values().length)];
			if(modelClass == GenericModel.class){
				modelDao.add(new GenericModel(name, description, businessUnit, 1));
			}
			if(modelClass == PVRMModel.class){
				String modelOwner = RandomStringUtils.random(5, "ABCDEFG");
				modelDao.add(new PVRMModel(name, description, businessUnit, modelOwner));
			}
		}
	}
	
	public List<? extends Model> findModels(ModelSearchParam modelSearchParam){
		return modelDao.searchByView(modelSearchParam);
	}
	
	

}
