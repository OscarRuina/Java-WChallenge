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
@Table(name = "company")
public class CompanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCompany")
	private long idCompany;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "catcPhrase")
	private String catchPhrase;
	
	@Column(name = "bs")
	private String bs;
	
	@Column(name = "createAt")
	@CreationTimestamp
	private LocalDate createAt;
	
	@Column(name = "updateAt")
	@UpdateTimestamp
	private LocalDate updateAt;
	
	@OneToOne(mappedBy = "company" , cascade = CascadeType.ALL)
	private UserEntity user;
	
	public CompanyEntity ( ) {}

	public CompanyEntity(String name, String catchPhrase, String bs, UserEntity user) {
		super();
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
		this.user = user;
	}

	public long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CompanyEntity [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}
	
}
