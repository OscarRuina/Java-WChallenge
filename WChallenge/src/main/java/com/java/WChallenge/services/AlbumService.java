package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.models.Album;

@Service
public class AlbumService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Album> getAlbums(){
		Album[] album = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums",Album[].class);
		List<Album> albums = Arrays.asList(album);
		return albums;
	}
	
	public List<Album> getAlbumsByUser(long userId){
		String id = String.valueOf(userId);
		Album[] album = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums?userId=" + id,Album[].class);
		List<Album> albums = Arrays.asList(album);
		return albums; 	
	}

}
