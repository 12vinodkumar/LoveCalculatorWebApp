package com.example.lc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.example.lc")
@PropertySource("classpath:message.properties")
public class LoveCalculatorApplicationConfig {
	@Autowired
	private Environment env;
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internaviewResolver = new InternalResourceViewResolver();
		internaviewResolver.setPrefix("/WEB-INF/view/");
		internaviewResolver.setSuffix(".jsp");
		return internaviewResolver;
	}

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		System.out.println(env.getProperty("email.host"));
		javaMailSenderImpl.setHost(env.getProperty("email.host"));
		javaMailSenderImpl.setUsername(env.getProperty("email.username"));
		javaMailSenderImpl.setPassword(env.getProperty("email.password"));
		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("email.port")));
		

		Properties mailProperties = new Properties();
		mailProperties.put("mail.transport.protocol", "smtp");
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailProperties.put("mail.smtp.EnableSSL.enable","true");
		mailProperties.put("mail.smtp.auth", "true");
		mailProperties.put("mail.smtp.socketFactory.class",
				 "javax.net.ssl.SSLSocketFactory");
		mailProperties.put("mail.smtp.socketFactory.fallback", "false");

		javaMailSenderImpl.setJavaMailProperties(mailProperties);
		return javaMailSenderImpl;
	}

}
