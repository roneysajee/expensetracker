package com.roney.expensetracker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roney.expensetracker.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
