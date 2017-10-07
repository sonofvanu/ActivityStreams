package com.stackroute.activitystream.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.backend.dao.UserDAO;
import com.stackroute.activitystream.backend.model.UserRegistration;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/")
	public String sample()
	{
		return "hello";
	}
	
	@GetMapping(value = "/user/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRegistration> getUser(@PathVariable("email") String email) {
		System.out.println("Fetching User with name " + email);
		UserRegistration singleUser = userDAO.findByEmail(email);
		if (singleUser == null) {
			System.out.println("User with name " + email + " not found");
			return new ResponseEntity<UserRegistration>(HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<UserRegistration>(singleUser, HttpStatus.OK);
		}
	}
	
	
	@PostMapping(value = "/user/")
	public ResponseEntity<String> createUser(@RequestBody UserRegistration userModel) {
		System.out.println("Creating User " + userModel.getUserName());
		if (userDAO.findByEmail(userModel.getUserEmail()) == null) {
			userDAO.saveUser(userModel);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value = "/user")
	public ResponseEntity<List<UserRegistration>> listAllUsers() {
		List<UserRegistration> users = userDAO.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserRegistration>>(HttpStatus.NO_CONTENT);} else {
			return new ResponseEntity<List<UserRegistration>>(users, HttpStatus.OK);
		}
	}
	
	
	@PutMapping(value = "/user/{email}")
	public ResponseEntity<UserRegistration> updateUser(@PathVariable("email") String email, @RequestBody UserRegistration user) {
		System.out.println("Fetching & updating User with email " + email);
		UserRegistration currentuser = userDAO.findByEmail(email);
		if (currentuser == null) {
			System.out.println("Unable to update. User with email " + email + " not found");
			return new ResponseEntity<UserRegistration>(HttpStatus.NOT_FOUND);
		} else {
			userDAO.updateUser(user);
			return new ResponseEntity<UserRegistration>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value = "/user/{emailId}")
	public ResponseEntity<UserRegistration> deleteUser(@PathVariable("emailId") String emailId) {
		System.out.println("Fetching & Deleting User with email " + emailId);
		UserRegistration user = userDAO.findByEmail(emailId);
		System.out.println("user is......"+user);
		if (user == null) {
			System.out.println("Unable to delete. User with name " + emailId + " not found");
			return new ResponseEntity<UserRegistration>(HttpStatus.NOT_FOUND);
		}
System.out.println("going to delete....");
		userDAO.deleteUserByEmail(emailId);
		return new ResponseEntity<UserRegistration>(HttpStatus.OK);
	}

}
