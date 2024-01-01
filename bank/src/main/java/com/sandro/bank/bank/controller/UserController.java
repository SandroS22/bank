package com.sandro.bank.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.bank.bank.model.User;
import com.sandro.bank.bank.service.UserService;

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

}
