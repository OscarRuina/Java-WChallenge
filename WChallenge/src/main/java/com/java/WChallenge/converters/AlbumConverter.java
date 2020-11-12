package com.java.WChallenge.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.java.WChallenge.entities.AlbumEntity;
import com.java.WChallenge.entities.UserEntity;
import com.java.WChallenge.models.AlbumModel;
import com.java.WChallenge.repositories.UserRepository;

@Component
public class AlbumConverter {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	public AlbumModel EntityToModel(AlbumEntity entity) {
		AlbumModel model = new AlbumModel(entity.getUser().getId(),
				entity.getIdAlbum(),entity.getTitle());
		return model;
	}
	
	public AlbumEntity ModelToEntity(AlbumModel model) {
		UserEntity user = userRepository.findById(model.getUserId());
		AlbumEntity entity = new AlbumEntity(user,model.getTitle());
		return entity;
	}

}
