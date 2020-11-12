package com.java.WChallenge.converters;

import org.springframework.stereotype.Component;

import com.java.WChallenge.entities.UserEntity;
import com.java.WChallenge.models.AddressModel;
import com.java.WChallenge.models.CompanyModel;
import com.java.WChallenge.models.GeoModel;
import com.java.WChallenge.models.UserModel;

@Component
public class UserConverter {
	
	public UserModel EntityToModel(UserEntity entity) {
		GeoModel geo = new GeoModel(entity.getAddress().getGeo().getLat(),entity.getAddress().getGeo().getLng());
		AddressModel address = new AddressModel(entity.getAddress().getStreet(),
				entity.getAddress().getSuite(),
				entity.getAddress().getCity(),
				entity.getAddress().getZipcode(),
				geo);
		CompanyModel company = new CompanyModel(entity.getCompany().getName(),
				entity.getCompany().getCatchPhrase(),
				entity.getCompany().getBs());
		UserModel model = new UserModel(entity.getId(),entity.getName(),
				entity.getUsername(),entity.getEmail(),
				address,entity.getPhone(),entity.getWebsite(),company);
		return model;
	}
	
	public UserEntity ModelToEntity(UserModel model) {
		UserEntity entity = new UserEntity(model.getName(),model.getUsername(),
				model.getEmail(),model.getPhone(),model.getWebsite());
		return entity;
	}

}
