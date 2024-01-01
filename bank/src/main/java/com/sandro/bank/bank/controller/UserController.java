package com.sandro.bank.bank.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.bank.bank.model.User;
import com.sandro.bank.bank.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	public HttpStatus createUser(@Valid Long cpf, String name, String email, Date birthDate) {
		if (validateUser(cpf, name, email, birthDate)) {
			return HttpStatus.CREATED;
		} else {
			return HttpStatus.FAILED_DEPENDENCY;
		}
	}

	private Boolean validateUser(Long cpf, String name, String email, Date birthDate) {
		// TODO Auto-generated method stub
		return true;

	}

}
