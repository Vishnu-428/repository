package com.spring.pratice.service;

import java.util.List;

import com.spring.pratice.models.User;


public interface UserDetailsServiceInterface {

	public  User addUserData(User user);
	
	public  List<User> getUserData();
	
	public  User updateUserData(int id,User user);
	
	public String deleteUserData(int id);
	
	public User getUserDataById(int id);
}
