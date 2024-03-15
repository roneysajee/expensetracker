package com.roney.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNewDto {

	private String username;

	private String fullName;

	private String email;

	private String password;

}
