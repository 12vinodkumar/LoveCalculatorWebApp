package com.example.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.lc.DTO.UserInfoDTO;
import com.example.lc.DTO.UserRegistrationDto;

public class UserNameValidator implements Validator {

	public UserNameValidator (){}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("userRegName before removing white space");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userRegName", "User.empty", "userName cannot be empty");

		String userNameValidate = ((UserRegistrationDto) target).getUserRegName();
		System.out.println("userName : "+userNameValidate);

		if (!userNameValidate.contains("_")) {
			errors.rejectValue("userRegName", "userName.Empty", " * userName should contain _ ");
		}
	}

}
