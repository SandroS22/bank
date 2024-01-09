package com.sandro.bank.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandro.bank.bank.entity.Transaction;
import com.sandro.bank.bank.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	public Optional<Transaction> findById(Integer id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		return transaction;
	}

}
