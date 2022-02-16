package com.example.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.lc.DTO.UserInfoDTO;

public class LCAppControlValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserInfoDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Name.empty", "Spaces are inserted");
		UserInfoDTO userDTO = (UserInfoDTO)target;
		
		String onlyCharacters = "[a-zA-Z ]*$";
		
		String personName = userDTO.getUserName();
		String crushName =  userDTO.getCrushName();
		System.out.println("userName received "+personName+"length : "+personName.length());
		System.out.println("crushName received "+crushName+"length : "+crushName.length());
		if (!(personName.matches(onlyCharacters)))
		{
			errors.rejectValue("userName", "userName.invalid", " * Digits and Specail characters not Allowed * ");
		}
		if (!(crushName.matches(onlyCharacters)))
		{
			errors.rejectValue("crushName", "crushName.invalid", " * Digits and Specail characters not Allowed * ");
		}
		
	}

}
