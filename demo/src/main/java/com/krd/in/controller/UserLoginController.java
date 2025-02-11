package com.krd.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krd.in.entity.UserEntity;
import com.krd.in.service.UserService;

@RestController
@RequestMapping("/auth/user")
public class UserLoginController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody UserEntity request){
		
	String msg=	userService.addUser(request);
	return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserEntity request){
	String msg=	userService.loginUser(request);
	return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
	}
}
