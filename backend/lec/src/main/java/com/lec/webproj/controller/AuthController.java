package com.lec.webproj.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lec.webproj.dto.LoginDTO;
import com.lec.webproj.service.UserService;
import com.lec.webproj.utility.JwtUtility;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class AuthController {
	private final UserService userService;
	
	@PostMapping("/api/auth/jwt/login")
	public ResponseEntity<Map<String, Object>> authJwtLogin(@RequestBody LoginDTO dto, HttpServletResponse response) {
		Map<String, Object> responseBody = new HashMap<>();
		Cookie cookie = null;
		
		try {
			cookie = userService.login(dto);
		} catch (RuntimeException e) {
			responseBody.put("success", false);
			responseBody.put("msg", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
		} catch (Exception e) {
			responseBody.put("success", false);
			responseBody.put("msg", "서버 오류");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
		}
		
	    response.addCookie(cookie);
		responseBody.put("success", true);
		responseBody.put("msg", "로그인 성공");
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
	@PostMapping("/api/auth/jwt/logout")
	public String authJwtLogout(@RequestBody String entity) {
		return null;
	}
}