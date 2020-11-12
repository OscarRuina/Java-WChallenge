package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.converters.UserConverter;
import com.java.WChallenge.models.UserModel;
import com.java.WChallenge.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	public List<UserModel> getUsers(){
		UserModel[] user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", UserModel[].class);
		List<UserModel> users = Arrays.asList(user);
		return users;
	}
	
	public void insertUsers() {
		List<UserModel> users = this.getUsers();
		for(UserModel m : users) {
			userRepository.save(userConverter.ModelToEntity(m));
		}
		
	}
	
}
