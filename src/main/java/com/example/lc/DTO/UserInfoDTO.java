package com.example.lc.DTO;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

	@NotBlank(message = " * userName cannot be blank")
	@Size(min = 3, max = 25, message = " * Your Name should be in between 3 and 25")
	private String userName;
	@NotBlank(message = " * crush Name cannot be blank")
	@Size(min = 3, max = 25, message = " * crush Name should be in between 3 and 25")
	private String crushName;
	@AssertTrue(message = "You need to Agree for terms & condition")
	private boolean termsAndConditionAccepted;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermsAndConditionAccepted() {
		return termsAndConditionAccepted;
	}

	public void setTermsAndConditionAccepted(boolean termsAndConditionAccepted) {
		this.termsAndConditionAccepted = termsAndConditionAccepted;
	}

}
