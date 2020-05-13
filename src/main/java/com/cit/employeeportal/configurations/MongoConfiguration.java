package com.cit.employeeportal.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {
	
	public @Bean MongoTemplate mongoTemplate() throws Exception {
		
		MongoTemplate mongoTemplate = 
		    new MongoTemplate(new MongoClient("localhost"),"employee-portal");
		return mongoTemplate;
		
	}

}
