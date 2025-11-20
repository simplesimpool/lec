package com.lec.webproj.service;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.dto.LoginDTO;

public interface UserService {
	void join(JoinDTO dto);
	void login(LoginDTO dto);
}
