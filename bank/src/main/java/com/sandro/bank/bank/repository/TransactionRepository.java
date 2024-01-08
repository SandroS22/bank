package com.sandro.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandro.bank.bank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
