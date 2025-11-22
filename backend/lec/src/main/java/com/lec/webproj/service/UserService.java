package com.lec.webproj.service;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.dto.LoginDTO;

import jakarta.servlet.http.Cookie;

public interface UserService {
	void join(JoinDTO dto);
	Cookie login(LoginDTO dto);
}
