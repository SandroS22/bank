package com.sandro.bank.bank.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account implements Serializable {

	private static final long serialVersionUID = 6637313898568372505L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private User userOwner;

	private Date createdAt;

	private Boolean active;

	public Account(User userOwner, Date createdAt, Boolean active) {
		this.userOwner = userOwner;
		this.createdAt = createdAt;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}