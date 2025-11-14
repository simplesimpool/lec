package com.lec.webproj.dto;

import java.lang.reflect.Field;

import lombok.Data;

@Data
public class JoinDTO implements CommonDTOHandler {
	private String userId;
	private String userPw;
	private String userName;
	private String userNickName;
	private String userEmail;
	
	@Override
	public Boolean isNullDataExist() throws IllegalArgumentException, IllegalAccessException {
		Object value = null;
		
		for (Field field : this.getClass().getDeclaredFields()) {
			value = field.get(this);
			if (value == null) {
				return true;
			}
		}
		
		return false;
	}
}
