package com.sandro.bank.bank.model;

import java.util.Date;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@UniqueElements
	private Long cpf;

	private String name;

	@UniqueElements
	private String email;

	private Date birthDate;

	public User() {
	}

	public User(Long cpf, String name, String email, Date birthDate) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
