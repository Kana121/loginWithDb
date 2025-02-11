package com.krd.in.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.krd.in.entity.UserEntity;
import com.krd.in.repository.UserRepositery;
import com.krd.in.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepositery userRepositery;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authManager;

	@Override
	public String addUser(UserEntity request) {
		UserEntity userData=new UserEntity();
		String encodedPwd = passwordEncoder.encode(request.getPassword());
		userData.setPassword(encodedPwd);
		userData.setFirstName(request.getFirstName());
		userData.setMiddleName(request.getMiddleName());
		userData.setLastName(request.getLastName());
		userData.setPhoneNumber(request.getPhoneNumber());
		userData.setCreatedDate(LocalDateTime.now());
		userData.setEmail(request.getEmail());
		userRepositery.save(userData);
		return "user added successfull...";
	}
	@Override
	public String loginUser(UserEntity request) {
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword());
		try {
			Authentication authentication=authManager.authenticate(token);
			if(authentication.isAuthenticated()) {
				return "Welcome login success...";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "incorrect username and password";
	}
}
