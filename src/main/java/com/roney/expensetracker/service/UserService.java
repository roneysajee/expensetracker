package com.roney.expensetracker.service;

import com.roney.expensetracker.dto.UserDto;
import com.roney.expensetracker.dto.UserNewDto;
import com.roney.expensetracker.entities.User;

public interface UserService {

	public User readUser(int user) ;
	public User updateUser(UserDto user);
	public User createUser(UserNewDto user);
	public boolean deleteUser(UserDto user);
	public boolean isExistingUser(UserDto user);
	
	//TODO passwordchange, emailverify, quick email and username check

}
