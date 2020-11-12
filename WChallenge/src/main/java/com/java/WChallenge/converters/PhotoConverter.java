package com.java.WChallenge.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.java.WChallenge.entities.AlbumEntity;
import com.java.WChallenge.entities.PhotoEntity;
import com.java.WChallenge.models.PhotoModel;
import com.java.WChallenge.repositories.AlbumRepository;

@Component
public class PhotoConverter {
	
	@Autowired
	@Qualifier("albumRepository")
	private AlbumRepository albumRepository;
	
	public PhotoModel EntityToModel(PhotoEntity entity) {
		PhotoModel model = new PhotoModel(entity.getAlbum().getIdAlbum(),
				entity.getIdPhoto(),entity.getTitle(),
				entity.getUrl(),entity.getThumbnailUrl());
		return model;
	}
	
	public PhotoEntity ModelToEntity(PhotoModel model) {
		AlbumEntity album = albumRepository.findByIdAlbum(model.getAlbumId());
		PhotoEntity entity = new PhotoEntity(model.getTitle(),
				model.getUrl(),model.getThumbnailUrl(),
				album);
		return entity;
	}

}
