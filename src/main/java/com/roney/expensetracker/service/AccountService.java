package com.roney.expensetracker.service;

import java.util.List;

import com.roney.expensetracker.dto.AccountDto;
import com.roney.expensetracker.entities.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public Account updateAccount(AccountDto account);

	public Account deleteAccount(int accId);

	public List<Account> getAllAccounts(int userId);

	public Account getAccount(int accId);

	public Account changeBalance(float amount, int accId);

}
