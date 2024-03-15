package com.roney.expensetracker.serviceimpliment;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.roney.expensetracker.Exceptions.CustomResourceNotFoundException;
import com.roney.expensetracker.Exceptions.ExistingResourceException;
import com.roney.expensetracker.Exceptions.InvalidInputException;
import com.roney.expensetracker.dto.AccountDto;
import com.roney.expensetracker.entities.Account;
import com.roney.expensetracker.repositories.AccountRepository;
import com.roney.expensetracker.service.AccountService;
import com.roney.expensetracker.utilities.ServiceUtil;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accRepo;
	private ModelMapper mapper;

	public AccountServiceImpl(AccountRepository repo, ModelMapper mapper) {
		this.accRepo = repo;
		this.mapper = mapper;
	}

	@Override
	public Account createAccount(Account account) {

		if (ServiceUtil.isEmpty(account))
			throw new InvalidInputException();
		account.setName(account.getName().toLowerCase());
		Optional<Account> optional = accRepo.findByUserIdAndName(account.getUserId(), account.getName());
		if (optional.isPresent())
			throw new ExistingResourceException();
		return accRepo.save(account);
	}

	@Override
	public Account updateAccount(AccountDto account) {

		if (ServiceUtil.isEmpty(account))
			throw new InvalidInputException();
		account.setName(account.getName().toLowerCase());
		Optional<Account> optional = accRepo.findById(account.getAccountId());
		if (optional.isEmpty())
			throw new InvalidInputException("No Resource exists");
		Account tempAcc = optional.get();

		mapper.map(account, tempAcc);

		return accRepo.save(tempAcc);

	}

	@Override
	public Account deleteAccount(int accId) {
		Optional<Account> optional = accRepo.findById(accId);
		if (optional.isEmpty())
			throw new InvalidInputException();
		accRepo.delete(optional.get());
		return optional.get();
		//TODO complete record delete
	}

	@Override
	public List<Account> getAllAccounts(int userId) {
		List<Account> accList = accRepo.findByUserId(userId);

		if (accList.size() == 0)
			throw new CustomResourceNotFoundException();

		return accList;
	}

	@Override
	public Account getAccount(int accId) {
		Optional<Account> optional = accRepo.findById(accId);
		if (optional.isEmpty())
			throw new CustomResourceNotFoundException();

		return optional.get();
	}

	@Override
	public Account changeBalance(float amount, int accId) {

		Account acc = getAccount(accId);
		if (amount < 0) {
			if (acc.getBalance() < Math.abs(amount))
				throw new InvalidInputException("Not enough balance");
		}

		acc.setBalance(acc.getBalance() + amount);

		return accRepo.save(acc);
	}

}
