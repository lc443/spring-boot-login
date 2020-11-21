package com.leron.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.leron.models.Role;
import com.leron.models.User;
import com.leron.repository.UserRepository;
import com.leron.web.dto.UserRegistrationDTO;

public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@Override
	public User save(UserRegistrationDTO registrationDTO) {
		User user = new User(registrationDTO.getEmail(), registrationDTO.getFirstName(),
				registrationDTO.getLastName(), passwordEncoder.encode(registrationDTO.getPassword()),
				Arrays.asList(new Role("User_Role")));
		return  userRepository.save(user);
	}

	private Collection <? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user... invalid credentials");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	
	
}
