package com.spring.pratice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pratice.models.User;
import com.spring.pratice.service.UserDetailsServiceInterface;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/v1")
public class UserServiceController {

	@Autowired
	UserDetailsServiceInterface UserDetail;
	
	@GetMapping("/all")
    public ResponseEntity<List<User>> getAllData() {
		System.out.println("Testing");
    	List<User> user=UserDetail.getUserData();
    	
    	if(user!=null) return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    	
    	return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
    }
	
	
	@PostMapping("/all")
    public ResponseEntity<User> saveData(@RequestBody User user) {
		System.out.println("Testing");
		User userdata=UserDetail.addUserData(user);
		return new ResponseEntity<>(userdata,HttpStatus.ACCEPTED);
		
    }
	
	@GetMapping("/all/{id}")
    public ResponseEntity<User> getDataById(@PathVariable(value = "id") int id) {
		System.out.println("Testing");
		User userdata=UserDetail.getUserDataById(id);
		return new ResponseEntity<>(userdata,HttpStatus.ACCEPTED);
		
    }
	
	
	@PutMapping("/all/{id}")
    public ResponseEntity<User> updateData(@PathVariable(value = "id") int id,@RequestBody User user) {
		System.out.println("Testing");
		User userdata=UserDetail.updateUserData(id,user);
		return new ResponseEntity<>(userdata,HttpStatus.ACCEPTED);
		
    }
	
	@DeleteMapping("/all/{id}")
    public ResponseEntity<String> deleteData(@PathVariable int id) {
		System.out.println("Testing");
		String userdata=UserDetail.deleteUserData(id);
		return new ResponseEntity<>(userdata,HttpStatus.ACCEPTED);
		
    }
	
	
	
}
