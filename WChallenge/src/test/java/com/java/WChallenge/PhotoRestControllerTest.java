package com.java.WChallenge;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.java.WChallenge.controllers.PhotoRestController;
import com.java.WChallenge.services.PhotoService;

@WebMvcTest(PhotoRestController.class)
public class PhotoRestControllerTest {
	
	@MockBean
	private PhotoService service;
	
	@Test
	public void getPhotosShouldReturnAListFromService() throws Exception{
		assertNotNull(service.getPhotos());
	}
	
	@Test
	public void getPhotosByAlbumShouldReturnAListFromService() throws Exception{
		int id = 1;
		assertNotNull(service.getPhotosByAlbum(id));
	}

}
