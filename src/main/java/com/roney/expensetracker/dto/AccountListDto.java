package com.roney.expensetracker.dto;

import java.util.List;

import com.roney.expensetracker.entities.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountListDto {

	private List<Account> accounts;
}
