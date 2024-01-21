package com.sandro.bank.bank.service;

import java.util.List;
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

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public void delete(Account account) {
		accountRepository.delete(account);
	}

}
