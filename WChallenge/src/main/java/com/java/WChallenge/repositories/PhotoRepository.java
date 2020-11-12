package com.java.WChallenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.WChallenge.entities.PhotoEntity;

@Repository("photoRepository")
public interface PhotoRepository extends JpaRepository<PhotoEntity,Serializable>{}
