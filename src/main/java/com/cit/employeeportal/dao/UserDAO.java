package com.cit.employeeportal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cit.employeeportal.model.UserDO;

@Repository
public class UserDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	MongoOperations mongoOperation;

	public List<UserDO> getAllUsers() {
		return mongoTemplate.findAll(UserDO.class);
	}

	public List<UserDO> getUserById(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		return mongoOperation.find(query, UserDO.class, "user");
	}

	public UserDO addNewUser(UserDO userDO) {
		return userDO;
	}
	public UserDO updateUser(UserDO userDO) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(userDO.get_id()));
		Update update = new Update();
		update.set("password", userDO.getPassword());
		update.set("emailId", userDO.getEmailId());
		update.set("firstName", userDO.getFirstName());
		update.set("lastName", userDO.getLastName());
		update.set("designation", userDO.getDesignation());
		update.set("rating", userDO.getRating());
		update.set("experienceLevel", userDO.getExperienceLevel());
		update.set("communicationLevel", userDO.getCommunicationLevel());
		update.set("availability", userDO.getAvailability());
		update.set("mobile", userDO.getMobile());
		
		mongoTemplate.upsert(query, update, UserDO.class);
		return userDO;
	}
}
