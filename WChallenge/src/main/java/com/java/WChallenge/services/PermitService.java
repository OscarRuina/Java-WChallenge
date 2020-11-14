package com.java.WChallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.entities.AlbumEntity;
import com.java.WChallenge.entities.PermitEntity;
import com.java.WChallenge.entities.UserEntity;
import com.java.WChallenge.repositories.AlbumRepository;
import com.java.WChallenge.repositories.PermitRepository;
import com.java.WChallenge.repositories.UserRepository;

@Service
public class PermitService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("permitRepository")
	private PermitRepository permitRepository;
	
	@Autowired
	@Qualifier("albumRepository")
	private AlbumRepository albumRepository;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	public void insertSharedAlbum(long idAlbum, long idUser) {
		UserEntity user = userRepository.findById(idUser);
		AlbumEntity album = albumRepository.findByIdAlbum(idAlbum);
		PermitEntity permit = new PermitEntity(album,user);
		permitRepository.save(permit);
	}
	
	

}
