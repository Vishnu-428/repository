package com.spring.pratice.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.spring.pratice.models.User;
import com.spring.pratice.repos.UserDetailsRepo;

@Service
public class UserDetailsServiceInterfaceImpl implements UserDetailsServiceInterface {

	@Autowired
	private UserDetailsRepo repo;

	@Override
	@Cacheable(cacheNames="cacheUserInfo")
	public List<User> getUserData() {
		// TODO Auto-generated method stub
		System.out.println(repo.findAll().size());
		return repo.findAll();
	}
	

	@Override
	public User addUserData(User user) {
		System.out.println("savedata");
		return repo.save(user);
	}

	@Override
	@CachePut(cacheNames ="cacheUserInfo", key="#user.id")
	public User updateUserData(int id,User user) {
		System.out.println("updatedata");
		User userr=repo.save(user);
		return userr;
	}

	@Override
	@CacheEvict(cacheNames="cacheUserInfo", key="#id")  
	public String deleteUserData(int id) {
		System.out.println("deletedata");
		repo.deleteById((long)id);
		if(repo.findById((long)id).isEmpty()) {
			return "Successfully Deleted";
		}
		return "Not Deleted";
	}

	@Override
	@Cacheable(cacheNames="cacheUserInfo", key="#id")
	public User getUserDataById(int id) {
		System.out.println("getbyId");
		return repo.findById((long)id).get();
	}



}
