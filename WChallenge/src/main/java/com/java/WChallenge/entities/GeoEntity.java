package com.java.WChallenge.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "geo")
public class GeoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idGeo")
	private long idGeo;
	
	@Column(name = "lat")
	private String lat;
	
	@Column(name = "lng")
	private String lng;
	
	@Column(name = "createAt")
	@CreationTimestamp
	private LocalDate createAt;
	
	@Column(name = "updateAt")
	@UpdateTimestamp
	private LocalDate updateAt;
	
	@OneToOne(mappedBy = "geo" , cascade = CascadeType.ALL)
	private AddressEntity address;
	
	public GeoEntity() {}

	public GeoEntity(String lat, String lng, AddressEntity address) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.address = address;
	}

	public long getIdGeo() {
		return idGeo;
	}

	public void setIdGeo(long idGeo) {
		this.idGeo = idGeo;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public LocalDate getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "GeoEntity [lat=" + lat + ", lng=" + lng + "]";
	}
	
}
