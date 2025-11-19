package com.lec.webproj.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO implements CommonDTOHandler {
	private String userId;
	private String userPw;
	
	@Override
	public boolean isNullDataExists() {
		if (this.userId == null || this.userPw == null) return true; else return false;
	}
}
