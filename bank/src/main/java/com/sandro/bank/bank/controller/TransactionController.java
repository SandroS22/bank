package com.sandro.bank.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandro.bank.bank.entity.Transaction;
import com.sandro.bank.bank.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions")
	public List<Transaction> findAllTransactions() {
		return transactionService.findAll();
	}

	@GetMapping("/transactions/{id}")
	public Object findTransactionById(@PathVariable Integer id) {
		Optional<Transaction> transaction = transactionService.findById(id);
		if (transaction.isEmpty()) {
			return HttpStatus.BAD_REQUEST;
		} else {
			return transaction.get();
		}
	}
}
