package com.sandro.bank.bank.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandro.bank.bank.entity.User;
import com.sandro.bank.bank.repository.UserRepository;
import com.sandro.bank.bank.service.validation.user.CpfValidator;

import jakarta.validation.Valid;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public boolean validateUser(@Valid Long cpf, String name, String email, String password, Date birthDate) {
		return CpfValidator.validate(cpf);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
