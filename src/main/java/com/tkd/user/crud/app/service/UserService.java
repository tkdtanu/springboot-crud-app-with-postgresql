package com.tkd.user.crud.app.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkd.user.crud.app.dto.User;
import com.tkd.user.crud.app.exception.BadRequestException;
import com.tkd.user.crud.app.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll().stream().map(User::entityToDto).collect(Collectors.toList());
	}

	public User getUser(Long id) {
		return userRepository.findById(id).map(User::entityToDto)
				.orElseThrow(() -> new BadRequestException("Invalid User Id"));
	}

	public User createUser(User user) {
		return User.entityToDto(userRepository.save(user.toEntity()));
	}

	public User updateUser(Long id, User user) {
		user.setUserId(id);
		return User.entityToDto(userRepository.save(user.toEntity()));
	}

	public void deleteUser(Long id) {
		userRepository.deleteUserByUserId(id);
	}

	public void deleteAllUsers() {
		this.userRepository.deleteAll();
	}

}
