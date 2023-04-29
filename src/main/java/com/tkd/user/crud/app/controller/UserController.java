package com.tkd.user.crud.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tkd.user.crud.app.dto.User;
import com.tkd.user.crud.app.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAllUser() {
		userService.deleteAllUsers();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
}
