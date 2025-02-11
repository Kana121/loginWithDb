package com.krd.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krd.in.entity.UserEntity;

public interface UserRepositery extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

}
