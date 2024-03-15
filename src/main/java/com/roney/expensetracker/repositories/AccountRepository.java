package com.roney.expensetracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roney.expensetracker.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByUserId(int userId);
	Optional<Account> findByUserIdAndName(int userId,String name);
}
