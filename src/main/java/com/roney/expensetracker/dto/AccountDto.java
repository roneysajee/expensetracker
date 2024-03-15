package com.roney.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {


	private int accountId;
	
	private String name;

	private float balance;
	
	private int userId;
}
