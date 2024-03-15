package com.roney.expensetracker.serviceimpliment;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.roney.expensetracker.Exceptions.CustomResourceNotFoundException;
import com.roney.expensetracker.Exceptions.ExistingResourceException;
import com.roney.expensetracker.Exceptions.InvalidInputException;
import com.roney.expensetracker.dto.UserDto;
import com.roney.expensetracker.dto.UserNewDto;
import com.roney.expensetracker.entities.User;
import com.roney.expensetracker.repositories.UserRepository;
import com.roney.expensetracker.service.UserService;
import com.roney.expensetracker.utilities.ServiceUtil;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	public UserServiceImpl(UserRepository repo) {
		this.userRepo = repo;
	}

	@Override
	public User readUser(int userId) throws DataAccessException, CustomResourceNotFoundException {

		Optional<User> tempUser = userRepo.findById(userId);
		if (tempUser.isPresent()) {
			User user = tempUser.get();
			return user;
		} else {
			throw new CustomResourceNotFoundException();
		}

	}

//TODO modify update to check username and email.
	@Override
	public User updateUser(UserDto userDto) throws InvalidInputException {
		if (!ServiceUtil.isEmpty(userDto)) {
			userDto.setUsername(userDto.getUsername().toLowerCase());
			Optional<User> optional = userRepo.findById(userDto.getUserId());
			if (optional.isPresent()) {
				User tempUser = optional.get();

				if (userDto.getUsername() != null)
					tempUser.setUsername(userDto.getUsername());
				if (userDto.getEmail() != null)
					tempUser.setEmail(userDto.getEmail());
				if (userDto.getFullName() != null)
					tempUser.setFullName(userDto.getFullName());

				return userRepo.save(tempUser);

			} else {
				throw new CustomResourceNotFoundException();
			}
		} else {
			throw new InvalidInputException(userDto);
		}

	}

	@Override
	public User createUser(UserNewDto userDto) throws DataAccessException, ExistingResourceException {

		if (ServiceUtil.isEmpty(userDto))
			throw new InvalidInputException();
		userDto.setUsername(userDto.getUsername().toLowerCase());
		Optional<User> optional = userRepo.findByUsername(userDto.getUsername());
		if (optional.isPresent())
			throw new ExistingResourceException();
		User entity = mapper.map(userDto, User.class);
		entity = userRepo.save(entity);
		return entity;

	}

	@Override
	public boolean deleteUser(UserDto user) {
		// TODO create delete user service
		return false;
	}

	@Override
	public boolean isExistingUser(UserDto user) {
		user.setUsername(user.getUsername().toLowerCase());
		if (userRepo.findByUsername(user.getUsername()).isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
