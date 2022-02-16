package com.example.lc.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.lc.DTO.UserRegistrationDto;


@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Email.empty", "Email is Empty");
		String emailValidator = ((UserRegistrationDto)target).getEmail();
		System.out.println("Email "+ emailValidator);
		if (!emailValidator.endsWith("@gmail.com"))
		{
			errors.rejectValue("email","invalidEmail", "invalid email ID");
		}
		
	}

}
