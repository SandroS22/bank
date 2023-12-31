package com.sandro.bank.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sandro.bank.bank.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
