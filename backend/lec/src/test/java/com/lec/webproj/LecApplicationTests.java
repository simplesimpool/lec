package com.lec.webproj;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.lec.webproj.utility.JwtUtility;

import io.jsonwebtoken.Claims;

class LecApplicationTests {
	private final JwtUtility jwtUtility = new JwtUtility();
	private final UUID uuid = UUID.randomUUID();
	@Test
	void contextLoads() throws InterruptedException {
		
	}
}
