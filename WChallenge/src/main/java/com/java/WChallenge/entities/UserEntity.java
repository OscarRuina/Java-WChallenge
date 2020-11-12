package com.java.WChallenge.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private AddressEntity address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "website")
	private String website;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private CompanyEntity company;
	
	@Column(name = "createAt")
	@CreationTimestamp
	private LocalDate createAt;
	
	@Column(name = "updateAt")
	@UpdateTimestamp
	private LocalDate updateAt;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "user" , cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
	private Set<AlbumEntity> albums;
	
	public UserEntity() {}

	public UserEntity(String name, String username, String email, String phone, String website) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
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

	public Set<AlbumEntity> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<AlbumEntity> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", website=" + website + "]";
	}

}
