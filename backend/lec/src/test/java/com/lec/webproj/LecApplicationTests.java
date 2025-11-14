package com.lec.webproj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.webproj.dto.JoinDTO;

import lombok.RequiredArgsConstructor;

@SpringBootTest
class LecApplicationTests {
	
	@Test
	void contextLoads() throws IllegalArgumentException, IllegalAccessException {
		JoinDTO dto = new JoinDTO();
		dto.setUserId("userId1");
		dto.setUserPw("userEmail1");
		
		dto.isNullDataExist();
	}
}
