package com.ust.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ust.flightreservation.controllers.UserController;

@Component
public class EmailUtil {
	@Value("${com.ust.flightreservation.itinerary.email.body}")
	private String BODY = "Details are attached";
	
	@Value("${com.ust.flightreservation.itinerary.email.subject}")
	private String SUBJECT = "Itinerary for Flight";

	@Autowired
	private JavaMailSender sender;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	public void  sendItinerary(String toAddress, String filePath) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);		
			messageHelper.setSubject(SUBJECT);
			messageHelper.setText(BODY);
			messageHelper.addAttachment("Itinerary",new File(filePath));
			messageHelper.setTo(toAddress);
			
			LOGGER.info("Inside sendItinerary");
			
			sender.send(message);
		}
		catch(MessagingException e){
			e.printStackTrace();
		}
		
	}

}
