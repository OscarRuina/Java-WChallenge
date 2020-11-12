package com.java.WChallenge.converters;

import org.springframework.stereotype.Component;

import com.java.WChallenge.entities.AddressEntity;
import com.java.WChallenge.entities.CompanyEntity;
import com.java.WChallenge.entities.GeoEntity;
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
		AddressEntity address = new AddressEntity(model.getAddress().getStreet(),
				model.getAddress().getSuite(),
				model.getAddress().getCity(),
				model.getAddress().getZipcode(),
				entity);
		GeoEntity geo = new GeoEntity(model.getAddress().getGeo().getLat(),
				model.getAddress().getGeo().getLng(),address);
		address.setGeo(geo);
		CompanyEntity company = new CompanyEntity(model.getCompany().getName(),
				model.getCompany().getCatchPhrase(),
				model.getCompany().getBs(),
				entity);
		entity.setAddress(address);
		entity.setCompany(company);
		return entity;
	}

}
