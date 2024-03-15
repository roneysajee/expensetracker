package com.roney.expensetracker.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roney.expensetracker.dto.AccountDto;
import com.roney.expensetracker.entities.Account;
import com.roney.expensetracker.serviceimpliment.AccountServiceImpl;
import com.roney.expensetracker.utilities.ToListMapper;

@RestController
@RequestMapping("/expensetracker/v1/accounts")
public class AccountController {

	private AccountServiceImpl accService;
	private ModelMapper mapper;
	private ToListMapper listMapper;

	public AccountController(AccountServiceImpl accService, ModelMapper mapper, ToListMapper listMapper) {
		this.accService = accService;
		this.mapper = mapper;
		this.listMapper = listMapper;
	}

	@PostMapping("/create")
	public ResponseEntity<AccountDto> createAccount(@RequestBody Account account) {
		Account acc = accService.createAccount(account);
		AccountDto accDto = mapper.map(acc, AccountDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(accDto);
	}

	@PostMapping("/update")
	public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto account) {

		Account acc = accService.updateAccount(account);
		AccountDto accDto = mapper.map(acc, AccountDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(accDto);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<AccountDto> deleteAccount(@PathVariable int id) {
		
		Account acc = accService.deleteAccount(id);
		AccountDto accDto = mapper.map(acc, AccountDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(accDto);

	}
	
	@GetMapping("/findAll/{id}")
	public ResponseEntity<List<AccountDto>> getAllAccounts(@PathVariable int id){
		List<Account> accList = accService.getAllAccounts(id);
		List<AccountDto> accDtoList = listMapper.mapList(accList, AccountDto.class);
		System.out.println(accDtoList.toString());
		
		return ResponseEntity.status(HttpStatus.OK).body(accDtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable int id){
		Account acc =  accService.getAccount(id);
		AccountDto accDto =  mapper.map(acc, AccountDto.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(accDto);
	}
	
	@PostMapping("/changeBalance")
	public ResponseEntity<AccountDto> changeBalance(@RequestBody AccountDto accDto){
		
		Account acc = accService.changeBalance(accDto.getBalance(), accDto.getUserId());
		
		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(acc, AccountDto.class));
	}
	
}
