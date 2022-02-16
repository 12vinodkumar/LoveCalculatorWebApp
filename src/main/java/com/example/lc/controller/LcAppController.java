package com.example.lc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.lc.DTO.UserInfoDTO;
import com.example.lc.DTO.UserRegistrationDto;
import com.example.lc.propertyEditor.NameCustomEditor;
import com.example.lc.service.ILCAppService;
import com.example.lc.service.LCAppServiceImpl;
import com.example.lc.validator.EmailValidator;
import com.example.lc.validator.LCAppControlValidator;
import com.example.lc.validator.UserNameValidator;

@Controller
@SessionAttributes("userInfo")
public class LcAppController {
	
	@Autowired
	LCAppServiceImpl lcAppService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("userInfo", new UserInfoDTO() );
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	public String processHomePage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result, HttpServletRequest request ) {
		if (result.hasErrors()) {
			System.out.println("my form has error ");

			List<ObjectError> objAllerrors = result.getAllErrors();
			for (ObjectError err : objAllerrors) {
				System.out.println(" error " + err.getDefaultMessage());
			}
			return "home-page";
		}
		System.out.println("userName " + userInfoDTO.getUserName() + " crush Name : " + userInfoDTO.getCrushName());
//		model.addAttribute("userInfo", userInfoDTO);
//		model.addAttribute("userInfo", userInfoDTO);
		String lcAppResult = lcAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
		System.out.println(" RESULT : "+lcAppResult);
		HttpSession session = request.getSession();
		session.setAttribute("appResult", lcAppResult);
		return "process-homepage";
	}

	/**
	@RequestMapping("/register")
	public String registerUser(@ModelAttribute("userRegInfo") UserRegistrationDto userInfo) {
		return "registeruserDetails";
	}

	@RequestMapping("/registeredUser")
	public String registrationPage(@Valid @ModelAttribute("userRegInfo") UserRegistrationDto userInfo,
			BindingResult result) {
		System.out.println("name : " + userInfo.getPersonName());
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
*/
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("init Binder in LcAppController Called() ");
//		binder.setDisallowedFields("personName");

//		StringTrimmerEditor editor = new StringTrimmerEditor(true);
//		NameCustomEditor editor = new NameCustomEditor();
//		binder.registerCustomEditor(String.class, "personName", editor);
//		System.out.println("init Binder Called() 2");

		
		LCAppControlValidator validator =  new LCAppControlValidator();
		binder.addValidators(validator);
		
		StringTrimmerEditor editor = new StringTrimmerEditor(" ", false);
		binder.registerCustomEditor(String.class, "userName", editor);
		binder.registerCustomEditor(String.class, "crushName", editor);
		
//		NameValidator validator = new NameValidator();
//		binder.addValidators(validator);

//		UserNameValidator userNameObj = new UserNameValidator();
//		binder.addValidators(userNameObj);
//		System.out.println("init Binder Called() 3");
//
//		EmailValidator emailValidObj = new EmailValidator();
//		binder.addValidators(emailValidObj);

	}

}
