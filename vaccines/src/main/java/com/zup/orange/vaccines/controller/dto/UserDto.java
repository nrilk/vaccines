package com.zup.orange.vaccines.controller.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.zup.orange.vaccines.model.User;

public class UserDto {

	private Long id;
	private String name;
	private String email;
	private String cpf;
	private Timestamp birthDate;

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birthDate = user.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public static List<UserDto> convert(List<User> users) {
		return users.stream().map(UserDto::new).collect(Collectors.toList());
	}

}