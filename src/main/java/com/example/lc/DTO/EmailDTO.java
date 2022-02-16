package com.example.lc.DTO;

import javax.validation.constraints.NotBlank;

public class EmailDTO {
	@NotBlank
	String emailValue;

	public String getEmailValue() {
		return emailValue;
	}

	public void setEmailValue(String emailValue) {
		this.emailValue = emailValue;
	}
}
