package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.models.AlbumModel;

@Service
public class AlbumService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<AlbumModel> getAlbums(){
		AlbumModel[] album = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums",AlbumModel[].class);
		List<AlbumModel> albums = Arrays.asList(album);
		return albums;
	}
	
	public List<AlbumModel> getAlbumsByUser(long userId){
		String id = String.valueOf(userId);
		AlbumModel[] album = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums?userId=" + id,AlbumModel[].class);
		List<AlbumModel> albums = Arrays.asList(album);
		return albums; 	
	}
	
}
