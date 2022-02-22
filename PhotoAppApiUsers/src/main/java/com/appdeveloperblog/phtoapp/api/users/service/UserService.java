package com.appdeveloperblog.phtoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appdeveloperblog.phtoapp.api.users.shared.UserDto;

public interface UserService extends UserDetailsService{

	
	UserDto createUser(UserDto userDetails);
	
	UserDto getUserDetailsByEmail(String username);
	
}
