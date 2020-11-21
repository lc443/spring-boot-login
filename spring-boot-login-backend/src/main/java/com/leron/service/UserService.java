package com.leron.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.leron.models.User;
import com.leron.web.dto.UserRegistrationDTO;

public interface UserService extends UserDetailsService{
	public User save(UserRegistrationDTO registrationDTO);

}
