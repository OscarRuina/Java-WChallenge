package com.java.WChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.helpers.ViewRouteHelper;
import com.java.WChallenge.models.AlbumModel;
import com.java.WChallenge.services.AlbumService;

@RestController
@RequestMapping("/")
public class AlbumRestController {
	
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("GET/albums")
	public List<AlbumModel> getAlbums(){
		return albumService.getAlbums();
	}
	
	@GetMapping("GET/albums/user/:{userId}")
    public List<AlbumModel> getAlbumsByUser(@PathVariable("userId") long userId)throws Exception{
    	return albumService.getAlbumsByUser(userId);
    }
	
	@GetMapping("POST/albums")
	public String insertAlbums() {
		albumService.insertAlbums();
		return ViewRouteHelper.INSERTS;
	}
	
}
