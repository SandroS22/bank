package com.sandro.bank.bank.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.bank.bank.entity.Account;
import com.sandro.bank.bank.entity.Transaction;
import com.sandro.bank.bank.service.AccountService;
import com.sandro.bank.bank.service.TransactionService;
import com.sandro.bank.bank.util.exception.OriginAccountSameAsDestinyAccountException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AccountService accountService;

	@GetMapping("/transactions")
	public List<Transaction> findAllTransactions() {
		return transactionService.findAll();
	}

	@GetMapping("/transactions/{id}")
	public Transaction findTransactionById(@PathVariable Integer id) {
		Optional<Transaction> transaction = transactionService.findById(id);
		if (transaction.isEmpty()) {
			return null;
		} else {
			return transaction.get();
		}
	}

	@PostMapping("/transactions/{origin}/{destination}")
	public HttpStatus newTransaction(Date date, Float value, @PathVariable("origin") Integer origin,
			@PathVariable("destination") Integer destination) {
		Optional<Account> originAccount = accountService.findById(origin);
		Optional<Account> destinyAccount = accountService.findById(destination);
		if (originAccount == null || destinyAccount == null) {
			return HttpStatus.BAD_REQUEST;
		}
		try {
			if (origin == destination) {
				throw new OriginAccountSameAsDestinyAccountException();
			} else {
				return HttpStatus.ACCEPTED;
			}
		} catch (OriginAccountSameAsDestinyAccountException exception) {
			return HttpStatus.BAD_REQUEST;
		}
	}
}
