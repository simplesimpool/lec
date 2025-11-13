package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
