package org.couchdb.lightcouch.config;

import org.lightcouch.CouchDbClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.couchdb.lightcouch.repository", "org.couchdb.lightcouch.service"})
public class LightCouchSpringConfig {
	
	@Bean(destroyMethod = "shutdown")
	public CouchDbClient couchDbClient(){
		return new CouchDbClient();
	}

}
