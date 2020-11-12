package com.java.WChallenge.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.WChallenge.entities.UserEntity;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity,Serializable>{
	
	public abstract List<UserEntity> findAll();
	
}
