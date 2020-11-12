package com.java.WChallenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.WChallenge.entities.AlbumEntity;

@Repository("albumRepository")
public interface AlbumRepository extends JpaRepository<AlbumEntity,Serializable>{
	
	public abstract AlbumEntity findByIdAlbum(long idAlbum);
	
}
