package com.java.WChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.models.Album;
import com.java.WChallenge.services.AlbumService;

@RestController
@RequestMapping("/GET")
public class AlbumController {
	
	@Autowired
	AlbumService albumService;
	
	@GetMapping("/albums")
	public List<Album> getAlbums(){
		return albumService.getAlbums();
	}
	
	@GetMapping("/albums/user/:{userId}")
    public List<Album> getAlbumsByUser(@PathVariable("userId") long userId)throws Exception{
    	return albumService.getAlbumsByUser(userId);
    }
	
    

}
