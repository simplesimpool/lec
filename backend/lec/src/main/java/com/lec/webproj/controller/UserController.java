package com.lec.webproj.controller;

import java.util.HashMap;
import java.util.Map;

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
public class UserController {
	private final UserService userService;
	
	@PostMapping("/api/users")
	public ResponseEntity<Map<String, Object>> join(@RequestBody JoinDTO dto) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			userService.join(dto);
		} catch (RuntimeException e) {
			response.put("success", false);
			response.put("msg", "이미 존재하는 아이디 이거나 중복된 닉네임입니다.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		} catch (Exception e) {
			response.put("success", false);
			response.put("msg", "내부 서버 오류");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		response.put("success", true);
		response.put("msg", "회원가입 성공");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
