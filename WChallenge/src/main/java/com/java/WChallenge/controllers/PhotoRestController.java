package com.java.WChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.models.PhotoModel;
import com.java.WChallenge.services.PhotoService;

@RestController
@RequestMapping("/GET")
public class PhotoRestController {
	
	@Autowired
	PhotoService photoService;
	
	@GetMapping("/photos")
	public List<PhotoModel> getPhotos(){
		return photoService.getPhotos();
	}
	
}
