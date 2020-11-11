package com.java.WChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.models.User;
import com.java.WChallenge.services.UserService;

@RestController
@RequestMapping("/GET")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	
	
	
	

}
