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
@Table(name = "permits")
public class PermitEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPermit")
	private long idPermit;
	
	@Column(name = "readP")
	private boolean read;
	
	@Column(name = "writeP")
	private boolean write;
	
	@Column(name = "createAt")
	@CreationTimestamp
	private LocalDate createAt;
	
	@Column(name = "updateAt")
	@UpdateTimestamp
	private LocalDate updateAt;
	
	@ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
	@JoinColumn(name = "idAlbum")
	private AlbumEntity album;
	
	@ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
	@JoinColumn(name = "idUser")
	private UserEntity user;
	
	public PermitEntity() {}
	
	public PermitEntity(AlbumEntity album, UserEntity user,boolean read, boolean write) {
		super();
		this.album = album;
		this.user = user;
		this.read = read;
		this.write = write;
	}
	
	public long getIdPermit() {
		return idPermit;
	}

	public void setIdPermit(long idPermit) {
		this.idPermit = idPermit;
	}
    
	public boolean isRead() {
		return read;
	}
	
	public void setRead(boolean read) {
		this.read = read;
	}
	
	public boolean isWrite() {
		return write;
	}
	
	public void setWrite(boolean write) {
		this.write = write;
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
	
	public AlbumEntity getAlbum() {
		return album;
	}

	public void setAlbum(AlbumEntity album) {
		this.album = album;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PermitEntity [idPermit=" + idPermit + ", read=" + read + ", write=" + write + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + "]";
	}

}
