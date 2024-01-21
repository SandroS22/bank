package com.sandro.bank.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandro.bank.bank.entity.Account;
import com.sandro.bank.bank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Optional<Account> findById(Integer id) {
		return accountRepository.findById(id);
	}

}
