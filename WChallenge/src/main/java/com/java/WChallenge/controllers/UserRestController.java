package com.java.WChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.helpers.ViewRouteHelper;
import com.java.WChallenge.models.UserModel;
import com.java.WChallenge.services.UserService;

@RestController
@RequestMapping("/")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("GET/users")
	public List<UserModel> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("POST/users")
	public String insertUsers() {
		userService.insertUsers();
		return ViewRouteHelper.INSERTS;
	}
	
}
