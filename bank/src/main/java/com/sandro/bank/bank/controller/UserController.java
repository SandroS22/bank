package com.sandro.bank.bank.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.bank.bank.entity.User;
import com.sandro.bank.bank.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@PostMapping("/register")
	public HttpStatus createUser(@Valid @RequestParam Long cpf, String name, String email, Date birthDate) {
		if (userService.validateUser(cpf, name, email, birthDate)) {
			return HttpStatus.CREATED;
		} else {
			return HttpStatus.FAILED_DEPENDENCY;
		}
	}

	@GetMapping("/register")
	public List<String> test() {
		List<String> lista = new ArrayList<>();
		lista.add("Sandro");
		return lista;
	}

}
