package com.zup.orange.vaccines.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.model.VaxImmunization;

public class UserDto {

	private Long id;
	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	
	private List<VaxImmunization> vaxImmunizations;
	
	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birthDate = user.getBirthDate();
		this.vaxImmunizations = user.getVaxImmunizations();
	}
	
//	private VaxImmunization vaxImmunization;
	
//	public VaxImmunization getVaxImmunization() {
//		return vaxImmunization;
//	}
//
//	public void setVaxImmunization(VaxImmunization vaxImmunization) {
//		this.vaxImmunization = vaxImmunization;
//	}

	public List<VaxImmunization> getVaxImmunization() {
		return vaxImmunizations;
	}

	public void setVaxImmunization(List<VaxImmunization> vaxImmunizations) {
		this.vaxImmunizations = vaxImmunizations;
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

	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getBirthDate() {
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

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public static List<UserDto> convert(List<User> users) {
		return users.stream().map(UserDto::new).collect(Collectors.toList());
	}

}
