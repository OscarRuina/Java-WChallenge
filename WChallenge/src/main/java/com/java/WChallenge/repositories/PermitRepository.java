package com.java.WChallenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.WChallenge.entities.PermitEntity;

@Repository("permitRepository")
public interface PermitRepository extends JpaRepository<PermitEntity,Serializable>{}
