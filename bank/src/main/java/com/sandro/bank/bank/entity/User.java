package com.sandro.bank.bank.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -3914210245535057132L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@UniqueElements
	private Long cpf;

	private String name;

	@UniqueElements
	private String email;

	private String password;

	private Date birthDate;

	@OneToOne
	private Account account;

	public User() {
	}

	public User(Long cpf, String name, String email, String password, Date birthDate) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
