package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.models.PhotoModel;

@Service
public class PhotoService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<PhotoModel> getPhotos(){
		PhotoModel[] photo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotoModel[].class);
		List<PhotoModel> photos = Arrays.asList(photo);
		return photos;
	}
	
}
