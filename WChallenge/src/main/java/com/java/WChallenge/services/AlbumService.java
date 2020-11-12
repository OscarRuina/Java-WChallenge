package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.converters.AlbumConverter;
import com.java.WChallenge.models.AlbumModel;
import com.java.WChallenge.repositories.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("albumRepository")
	private AlbumRepository albumRepository;
	
	@Autowired
	@Qualifier("albumConverter")
	private AlbumConverter albumConverter;
	
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
	
	public void insertAlbums() {
		List<AlbumModel> albums = this.getAlbums();
		for(AlbumModel a : albums) {
			albumRepository.save(albumConverter.ModelToEntity(a));
		}
		
	}
	
}
