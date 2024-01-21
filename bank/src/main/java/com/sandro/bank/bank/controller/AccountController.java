package com.sandro.bank.bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.bank.bank.entity.Account;
import com.sandro.bank.bank.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/account")
	public Object findAccountById(Integer id) {
		Optional<Account> account = accountService.findById(id);
		if (account.isEmpty()) {
			return HttpStatus.BAD_REQUEST;
		} else {
			return account.get();
		}
	}

}
