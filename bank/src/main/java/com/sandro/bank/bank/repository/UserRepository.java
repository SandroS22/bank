package com.sandro.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandro.bank.bank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
