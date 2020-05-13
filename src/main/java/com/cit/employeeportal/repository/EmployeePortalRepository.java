package com.cit.employeeportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cit.employeeportal.model.UserDO;

@Repository
public interface EmployeePortalRepository extends MongoRepository<UserDO, String> {

}
