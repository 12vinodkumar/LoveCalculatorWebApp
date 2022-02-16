package com.example.lc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.lc.DTO.EmailDTO;
import com.example.lc.DTO.UserInfoDTO;
import com.example.lc.service.ILCAppEmailService;
import com.example.lc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {
	
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailService;
	
	
	@GetMapping("sendEmail")
	public String sendEmail( Model model ) {
		
		model.addAttribute("emailDto", new EmailDTO());
//		model.addAttribute(userName);
		return "sendEmailPage";
	}
	
	@GetMapping("process-email")
	public String processSentEmail(@SessionAttribute("userInfo") UserInfoDTO userInfoDTO, @ModelAttribute("emailValueObj") EmailDTO emailValue, BindingResult result, HttpServletRequest request)
	{
		System.out.println("processed Email : "+emailValue.getEmailValue());
		if (result.hasErrors()) {
			System.out.println("my form has error ");
//			System.out.println("Age : " + userInfo.getAge());

			List<ObjectError> objAllerrors = result.getAllErrors();
			for (ObjectError err : objAllerrors) {
				System.out.println(" error " + err);
			}
		}
		HttpSession session = request.getSession();
		String lcAppResult = (String)session.getAttribute("appResult");
		lcAppEmailService.sendMail(userInfoDTO.getUserName(), emailValue.getEmailValue(), lcAppResult);
		
		return "process-email";
	}

}
