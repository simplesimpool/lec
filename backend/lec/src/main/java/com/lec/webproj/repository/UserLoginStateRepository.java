package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.UserLoginState;

public interface UserLoginStateRepository extends JpaRepository<UserLoginState, String> {
	
}
