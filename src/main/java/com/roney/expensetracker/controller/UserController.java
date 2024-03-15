package com.roney.expensetracker.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roney.expensetracker.dto.UserDto;
import com.roney.expensetracker.dto.UserNewDto;
import com.roney.expensetracker.entities.User;
import com.roney.expensetracker.serviceimpliment.UserServiceImpl;

@RestController()
@RequestMapping(value = "/expensetracker/v1/users")
public class UserController {

	private UserServiceImpl userService;

	@Autowired
	ModelMapper mapper;

	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserNewDto userDto) {
		User user = userService.createUser(userDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(user, UserDto.class));
	}

	@PostMapping("/update")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
		User user = userService.updateUser(userDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(user, UserDto.class));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable int id) {
		User user = userService.readUser(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(user, UserDto.class));
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}

}
