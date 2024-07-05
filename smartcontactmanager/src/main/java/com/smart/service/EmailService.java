package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String subject, String message, String to)
	{    
		 boolean f = false;
		try {
			
		   
			MimeMessage message1 = javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message1);
			
			helper.setFrom("baralsunil645@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(message, true);
			//helper.setText(message);
			
			
			javaMailSender.send(message1);
			 f = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
