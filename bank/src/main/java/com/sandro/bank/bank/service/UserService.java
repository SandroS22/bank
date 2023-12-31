package com.sandro.bank.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sandro.bank.bank.model.User;
import com.sandro.bank.bank.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
