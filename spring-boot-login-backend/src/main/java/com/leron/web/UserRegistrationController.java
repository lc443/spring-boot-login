package com.leron.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leron.models.User;
import com.leron.service.UserService;

import com.leron.web.dto.UserRegistrationDTO;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	
	
	
	@Autowired
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public User register(UserRegistrationDTO registrationDTO) {
		return userService.save(registrationDTO);
	}
	

}
