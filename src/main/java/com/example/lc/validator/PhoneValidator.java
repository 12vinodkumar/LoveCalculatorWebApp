package com.example.lc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, Long>{

	@Override
	public boolean isValid(Long phoneNumberValue, ConstraintValidatorContext context) {
		String phoneValue = phoneNumberValue.toString();
		String regex = "[0-9]";
		
		if (phoneValue.length() != 10 || phoneValue.matches(regex))
		{	
			return false;
		}
		return true;
	}

}
