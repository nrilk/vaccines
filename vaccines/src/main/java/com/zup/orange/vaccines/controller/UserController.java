package com.zup.orange.vaccines.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.zup.orange.vaccines.controller.dto.UserDto;
import com.zup.orange.vaccines.controller.form.UserForm;
import com.zup.orange.vaccines.controller.form.UserUpdateForm;
import com.zup.orange.vaccines.implementation.UserServiceImpl;
import com.zup.orange.vaccines.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserServiceImpl userServiceImpl;

	@Autowired
	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@GetMapping
	public List<UserDto> listUsers() {
		return userServiceImpl.getUsers();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUser(@RequestBody @Valid UserForm userForm) {
		return userServiceImpl.addNewUser(userForm);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateForm userForm) {
		return userServiceImpl.updateUser(id, userForm);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userServiceImpl.deleteUser(id);
	}
	
}
