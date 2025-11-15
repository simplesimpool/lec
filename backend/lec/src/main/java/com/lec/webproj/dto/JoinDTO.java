package com.lec.webproj.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JoinDTO {
	@NotBlank
	private String userId;
	@NotBlank
	private String userPw;
	@NotBlank
	private String userName;
	@NotBlank
	private String userNickName;
	@NotBlank
	private String userEmail;
}
