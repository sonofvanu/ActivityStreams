package com.stackroute.activitystream.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return new ResponseEntity<UserRegistration>(singleUser, HttpStatus.OK);
	}

}
