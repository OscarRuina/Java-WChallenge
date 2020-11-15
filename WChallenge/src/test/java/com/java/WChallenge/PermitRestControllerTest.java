package com.java.WChallenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.java.WChallenge.controllers.PermitRestController;
import com.java.WChallenge.services.PermitService;

@WebMvcTest(PermitRestController.class)
public class PermitRestControllerTest {
	
	@MockBean
	private PermitService service;
	
	@Test
	public void getUsersPermitByAlbumShouldReturnAListFromService() throws Exception{
		int id = 1;
		boolean read = true;
		boolean write = false;
		assertNotNull(service.getUsersPermitsByAlbum(id, read, write));
	}

}
