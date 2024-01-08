package com.sandro.bank.bank.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Date date;

	private Account origin;

	private Account destination;

	public Transaction() {

	}

	public Transaction(Date date, Account origin, Account destination) {
		this.date = date;
		this.origin = origin;
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getOrigin() {
		return origin;
	}

	public void setOrigin(Account origin) {
		this.origin = origin;
	}

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

}
