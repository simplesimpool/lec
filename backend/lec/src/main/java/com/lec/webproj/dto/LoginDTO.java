package com.lec.webproj.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginDTO {
	@NotBlank
	private String userId;
	@NotBlank
	private String userPw;
}
