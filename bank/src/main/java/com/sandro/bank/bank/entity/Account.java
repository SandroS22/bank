package com.sandro.bank.bank.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Account implements Serializable {

	private static final long serialVersionUID = 6637313898568372505L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;

	@OneToOne
	private User userOwner;

	private Date createdAt;

	private Float balance;

	public Account(User userOwner, Date createdAt) {
		this.userOwner = userOwner;
		this.createdAt = createdAt;
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

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
}
