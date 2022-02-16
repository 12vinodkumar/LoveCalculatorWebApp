package com.example.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements ILCAppEmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(String UserName, String userMail, String result) {
		System.out.println("userName : "+UserName+" user Mail :"+userMail+" result :"+result);
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(userMail);
		emailMsg.setFrom("vinodkumartestapp@gmail.com");
		emailMsg.setSubject("Love Calculator Application");
		emailMsg.setText("Hi "+UserName+" The Result predicted by the LCApp is "+result);
		mailSender.send(emailMsg);
	}

}
