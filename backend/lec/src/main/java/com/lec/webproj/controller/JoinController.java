package com.lec.webproj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JoinController {
private final UserService userService;
	@PostMapping("/api/join")
	public ResponseEntity<String> join(@RequestBody JoinDTO dto) {
		try {
			userService.join(dto);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 아이디 이거나 중복된 닉네임입니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
	}
}
