package com.java.WChallenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.java.WChallenge.controllers.UserRestController;
import com.java.WChallenge.services.UserService;

@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {
	
	@MockBean
	private UserService service;
	
	@Test
	public void getUserShouldReturnAListFromService() throws Exception{
		assertNotNull(service.getUsers());
	}

}
