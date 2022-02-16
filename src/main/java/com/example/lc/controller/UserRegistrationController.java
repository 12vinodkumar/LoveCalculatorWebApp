package com.example.lc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.lc.DTO.UserRegistrationDto;
import com.example.lc.propertyEditor.NameCustomEditor;
import com.example.lc.validator.EmailValidator;
import com.example.lc.validator.UserNameValidator;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private EmailValidator emailValidator;
	
	@RequestMapping("/register")
	public String registerUser(@ModelAttribute("userRegInfo") UserRegistrationDto userInfo) {
		return "registeruserDetails";
	}

	@RequestMapping("/registeredUser")
	public String registrationPage(@Valid @ModelAttribute("userRegInfo") UserRegistrationDto userInfo,
			BindingResult result) {
		System.out.println("name : " + userInfo.getPersonName());
		
		emailValidator.validate(userInfo, result);
		
		if (result.hasErrors()) {
			System.out.println("my form has error ");
			System.out.println("Age : " + userInfo.getAge());

			List<ObjectError> objAllerrors = result.getAllErrors();
			for (ObjectError err : objAllerrors) {
				System.out.println(" error " + err.getDefaultMessage());
			}
			return "registeruserDetails";
		}
		return "registeredUser";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("init Binder Called() ");
//		binder.setDisallowedFields("personName");

//		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		NameCustomEditor editor = new NameCustomEditor();
		binder.registerCustomEditor(String.class, "personName", editor);
		System.out.println("init Binder Called() 2");

		
		UserNameValidator userNameObj = new UserNameValidator();
		binder.addValidators(userNameObj);
		System.out.println("init Binder Called() 3");
//
//		EmailValidator emailValidObj = new EmailValidator();
//		binder.addValidators(emailValidObj);

	}

}
