package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.converters.PhotoConverter;
import com.java.WChallenge.models.PhotoModel;
import com.java.WChallenge.repositories.PhotoRepository;

@Service
public class PhotoService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("photoRepository")
	private PhotoRepository photoRepository;
	
	@Autowired
	@Qualifier("photoConverter")
	private PhotoConverter photoConverter;
	
	public List<PhotoModel> getPhotos(){
		PhotoModel[] photo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotoModel[].class);
		List<PhotoModel> photos = Arrays.asList(photo);
		return photos;
	}
	
	public void insertPhotos() {
		List<PhotoModel> photos = this.getPhotos();
		int i = 0;
		for(PhotoModel p : photos) {
			photoRepository.save(photoConverter.ModelToEntity(p));
			i++;
			if(i == 100)break;
		}
		
	}
	
}
