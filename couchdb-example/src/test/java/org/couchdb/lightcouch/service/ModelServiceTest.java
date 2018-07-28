package org.couchdb.lightcouch.service;

import org.couchdb.lightcouch.config.LightCouchSpringConfig;
import org.couchdb.lightcouch.object.GenericModel;
import org.couchdb.lightcouch.object.PVRMModel;
import org.couchdb.lightcouch.repository.searchparam.ModelSearchParam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LightCouchSpringConfig.class})
public class ModelServiceTest {
	
	@Autowired
	private ModelService modelService;
	
	@Test
	public void add10Models_and_search_success(){
		modelService.addModels(10, PVRMModel.class);
		Assert.assertEquals(10, modelService.findModels(new ModelSearchParam()).size());
	}
	
	@Test
	public void searchModels(){
		
	}

}
