package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.models.Photo;

@Service
public class PhotoService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Photo> getPhotos(){
		Photo[] photo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", Photo[].class);
		List<Photo> photos = Arrays.asList(photo);
		return photos;
	}
	
	
	
	

}
