package com.java.WChallenge.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.converters.UserConverter;
import com.java.WChallenge.entities.AlbumEntity;
import com.java.WChallenge.entities.PermitEntity;
import com.java.WChallenge.entities.UserEntity;
import com.java.WChallenge.models.UserModel;
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
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	public void insertSharedAlbum(long idAlbum, long idUser,boolean read,boolean write) {
		UserEntity user = userRepository.findById(idUser);
		AlbumEntity album = albumRepository.findByIdAlbum(idAlbum);
		PermitEntity permit = new PermitEntity(album,user,read,write);
		permitRepository.save(permit);
	}
	
	public void updateSharedAlbum(long idAlbum, long idUser,boolean read,boolean write) {
		List<PermitEntity> permits = permitRepository.findAll();
		for(PermitEntity p : permits) {
			if(p.getAlbum().getIdAlbum() == idAlbum && p.getUser().getId() == idUser) {
				p.setRead(read);
				p.setWrite(write);
				permitRepository.save(p);
			}
		}
	}
	
	public List<UserModel> getUsersPermitsByAlbum(long idAlbum,boolean read,boolean write){
		List<UserModel> users = new ArrayList<UserModel>();
		UserEntity u = new UserEntity();
		for(PermitEntity p : permitRepository.findAll()) {
			if(p.getAlbum().getIdAlbum() == idAlbum && p.isRead() == read && p.isWrite() == write) {
				u = userRepository.findById(p.getUser().getId());
				users.add(userConverter.EntityToModel(u));
			}
		}
		return users;
	}
	
}
