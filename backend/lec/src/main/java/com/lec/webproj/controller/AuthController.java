package com.lec.webproj.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class AuthController {
	private final UserService userService;
	
	@PostMapping("/api/auth/join")
	public ResponseEntity<String> join(@RequestBody JoinDTO dto) {
		System.out.println("asdfasd");
		int result = userService.join(dto);
		
		if (result > 0) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("이미 존재하는 아이디 이거나 중복된 닉네임입니다.");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
		}
	}
}