package com.spring.pratice.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pratice.models.User;
import com.spring.pratice.repos.UserDetailsRepo;

@Service
public class UserDetailsServiceInterfaceImpl implements UserDetailsServiceInterface {

	@Autowired
	private UserDetailsRepo repo;

	@Override
	public List<User> getUserData() {
		// TODO Auto-generated method stub
		System.out.println(repo.findAll().size());
		return repo.findAll();
	}
	

	@Override
	public User addUserData(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User updateUserData(int id,User user) {
		// TODO Auto-generated method stub
		User userr=repo.save(user);
		return userr;
	}

	@Override
	public String deleteUserData(int id) {
		repo.deleteById((long)id);
		if(!repo.findById((long)id).isEmpty()) {
			return "Successfully Deleted";
		}
		return "Not Deleted";
	}

	@Override
	public User getUserDataById(int id) {
		// TODO Auto-generated method stub
		return repo.findById((long)id).get();
	}



}
