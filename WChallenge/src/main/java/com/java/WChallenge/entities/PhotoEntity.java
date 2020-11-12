package com.java.WChallenge.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "photo")
public class PhotoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPhoto")
	private long idPhoto;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "thumbnailUrl")
	private String thumbnailUrl;
	
	@ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
	@JoinColumn(name = "idAlbum")
	private AlbumEntity album;
	
	@Column(name = "createAt")
	@CreationTimestamp
	private LocalDate createAt;
	
	@Column(name = "updateAt")
	@UpdateTimestamp
	private LocalDate updateAt;
	
	public PhotoEntity() {}

	public PhotoEntity(String title, String url, String thumbnailUrl, AlbumEntity album) {
		super();
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
		this.album = album;
	}

	public long getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(long idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public AlbumEntity getAlbum() {
		return album;
	}

	public void setAlbum(AlbumEntity album) {
		this.album = album;
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

	@Override
	public String toString() {
		return "PhotoEntity [title=" + title + ", url=" + url + ", thumbnailUrl=" + thumbnailUrl + "]";
	}
	
	

}
