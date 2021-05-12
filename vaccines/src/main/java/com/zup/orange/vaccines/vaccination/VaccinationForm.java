package com.zup.orange.vaccines.vaccination;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VaccinationForm {

	@NotEmpty @NotNull
	private String vaccineName;
	@Email @NotEmpty @NotNull
	private String userEmail;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vaccinationDate;

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(LocalDate vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public Vaccination convert() {
		return new Vaccination(vaccineName, userEmail, vaccinationDate);
	}

}