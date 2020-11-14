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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "album")
public class AlbumEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlbum")
	private long idAlbum;
	
	@ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
	@JoinColumn(name = "id")
	private UserEntity user;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "createAt")
	@CreationTimestamp
	private LocalDate createAt;
	
	@Column(name = "updateAt")
	@UpdateTimestamp
	private LocalDate updateAt;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "album" , cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
	private Set<PhotoEntity> photos;
	
	@OneToMany(mappedBy = "album")
	private Set<PermitEntity> permits;
	
	public AlbumEntity() {}

	public AlbumEntity(UserEntity user, String title) {
		super();
		this.user = user;
		this.title = title;
	}

	public long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(long idAlbum) {
		this.idAlbum = idAlbum;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Set<PhotoEntity> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<PhotoEntity> photos) {
		this.photos = photos;
	}
	
	public Set<PermitEntity> getPermits() {
		return permits;
	}

	public void setPermits(Set<PermitEntity> permits) {
		this.permits = permits;
	}

	@Override
	public String toString() {
		return "AlbumEntity [title=" + title + "]";
	}

}
