package com.sandro.bank.bank.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/users/{id}")
	public Object findUserById(@PathVariable Integer id) {
		Optional<User> user = userService.findById(id);
		if (user.isEmpty()) {
			return HttpStatus.BAD_REQUEST;
		} else {
			return user.get();
		}
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@PostMapping("/register")
	public HttpStatus createUser(@Valid @RequestParam(required = true) Long cpf, String name, String email,
			String password, Date birthDate) {
		if (userService.validateUser(cpf, name, email, password, birthDate)) {
			return HttpStatus.CREATED;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@PutMapping("/users/{id}")
	public HttpStatus updateUser(@Valid @PathVariable Integer id, @RequestParam(required = true) Long cpf, String name,
			String email, String password, Date birthDate) {
		if (userService.validateUser(cpf, name, email, password, birthDate)) {
			return HttpStatus.OK;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@DeleteMapping("/users/{id}")
	public HttpStatus deleteUser(@PathVariable Integer id) {
		Optional<User> user = userService.findById(id);
		if (user.isEmpty()) {
			return HttpStatus.BAD_REQUEST;
		} else {
			return HttpStatus.OK;
		}
	}

}
