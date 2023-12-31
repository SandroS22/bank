package com.sandro.bank.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.bank.bank.model.User;
import com.sandro.bank.bank.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	public List<User> findAllUsers() {
		return userService.findAll();
	}

}
