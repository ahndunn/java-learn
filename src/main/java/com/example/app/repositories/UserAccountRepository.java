package com.example.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    public Optional<UserAccount> findByEmail(String email);
}