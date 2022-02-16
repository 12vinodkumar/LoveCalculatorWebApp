package com.example.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationIntialiser //implements WebApplicationInitializer 
{
//	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("In Java side Tomcat called onStartUp >>>>> Vinod");

		// creating Dispacther servlet
		// xml type configuration
		/**
		 * XmlWebApplicationContext webApplicationContext = new
		 * XmlWebApplicationContext();
		 * webApplicationContext.setConfigLocation("classpath:application-config.xml");
		 */
		
		System.out.println("*************** Dispatcher Servlet is Created ***********");
		AnnotationConfigWebApplicationContext configContext = new AnnotationConfigWebApplicationContext();
		configContext.register(LoveCalculatorApplicationConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(configContext);

		ServletRegistration.Dynamic myServletContext = servletContext.addServlet("MyDispatcherServlet",
				dispatcherServlet);

		myServletContext.addMapping("/mywebsite.com/*");
		myServletContext.setLoadOnStartup(1);
		System.out.println("*************** Dispatcher Servlet is Created ***********");
	}

}
