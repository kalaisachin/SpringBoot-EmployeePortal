package com.cit.employeeportal.model;

import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection ="user")
public class UserDO {
	
	@Id
	private ObjectId _id;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String designation;
	
	private String emailId;
	
	private Float rating;
	
	private String experienceLevel;
	
	private Integer totalProjects;
	
	private String communicationLevel;
	
	private Float availability;
	
	private Long mobile;
	
	private Map<String, String> userProfile = new HashMap<>();
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	public Integer getTotalProjects() {
		return totalProjects;
	}
	public void setTotalProjects(Integer totalProjects) {
		this.totalProjects = totalProjects;
	}
	public String getCommunicationLevel() {
		return communicationLevel;
	}
	public void setCommunicationLevel(String communicationLevel) {
		this.communicationLevel = communicationLevel;
	}
	public Float getAvailability() {
		return availability;
	}
	public void setAvailability(Float availability) {
		this.availability = availability;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Map<String, String> getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(Map<String, String> userProfile) {
		this.userProfile = userProfile;
	}
}
