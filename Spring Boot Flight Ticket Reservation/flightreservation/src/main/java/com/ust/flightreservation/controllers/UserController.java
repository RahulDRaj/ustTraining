package com.ust.flightreservation.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ust.flightreservation.entities.User;
import com.ust.flightreservation.repos.UserRepository;
import com.ust.flightreservation.services.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityService securityService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping(value = "/registerUser", method= RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register()"+user);
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			@RequestParam("email") String email, 
			@RequestParam("password") String password, 
			ModelMap modelMap) {
		
		
		boolean loginResponse = securityService.login(email, password);
		LOGGER.info("Inside login() and email is :" +email+ "and password is" + password);
		
//		LOGGER.error("ERROR");
//		LOGGER.warn("WARN");
//		LOGGER.info("INFO");
//		LOGGER.debug("DEBUG");
//		LOGGER.trace("TRACE");
		
		
		
		User user = userRepository.findByEmail(email);
		//if(user.getPassword().equals(password)) 
		if(loginResponse)
		{
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid user name or password. Please try again");
		}
		
		return "login/login";
	}
	
}









