package com.java.WChallenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.java.WChallenge.controllers.AlbumRestController;
import com.java.WChallenge.services.AlbumService;

@WebMvcTest(AlbumRestController.class)
public class AlbumRestControllerTest {
	
	@MockBean
	private AlbumService service;
	
	@Test
	public void getAlbumShouldReturnAListFromService() throws Exception{
		assertNotNull(service.getAlbums());
	}
	
	@Test
	public void getAlbumShouldReturnAListByUserFromService()throws Exception{
		int id = 1;
		assertNotNull(service.getAlbumsByUser(id));
	}

}
