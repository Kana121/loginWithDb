package com.krd.in.service;

import com.krd.in.entity.UserEntity;

public interface UserService {

	String addUser(UserEntity request);

	String loginUser(UserEntity request);

}
