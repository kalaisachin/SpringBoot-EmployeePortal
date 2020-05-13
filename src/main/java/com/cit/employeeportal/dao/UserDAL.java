package com.cit.employeeportal.dao;

import java.util.List;

import com.cit.employeeportal.model.UserDO;


public interface UserDAL {

	List<UserDO> getAllUsers();

	UserDO getUserById(String userId);

	UserDO addNewUser(UserDO user);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
}
