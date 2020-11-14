package com.java.WChallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.helpers.ViewRouteHelper;
import com.java.WChallenge.services.PermitService;

@RestController
@RequestMapping("/")
public class PermitController {
	
	@Autowired
	private PermitService permitService;
	
	@GetMapping("POST/sharedAlbum/:{idAlbum}/user/:{idUser}")
	public String insertSharedAlbum(@PathVariable("idAlbum")long idAlbum, @PathVariable("idUser")long idUser) {
		permitService.insertSharedAlbum(idAlbum, idUser);
		return ViewRouteHelper.SHAREDALBUM;
	}

}
