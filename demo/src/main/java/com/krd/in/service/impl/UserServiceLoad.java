package com.krd.in.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.krd.in.entity.UserEntity;
import com.krd.in.repository.UserRepositery;

@Service
public class UserServiceLoad implements UserDetailsService {
	@Autowired
	private UserRepositery userRepositery;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepositery.findByEmail(username);
		return new User(user.getEmail(), user.getPassword(), Collections.EMPTY_LIST);
	}

}
