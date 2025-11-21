package com.lec.webproj;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.UUID;

import org.aspectj.weaver.bcel.UnwovenClassFile.ChildClass;
import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;

import com.lec.webproj.utility.JwtUtility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;

class LecApplicationTests {
	private final JwtUtility jwtUtility = new JwtUtility();
	private final UUID uuid = UUID.randomUUID();
	@Test
	void contextLoads() {
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			if (e instanceof RuntimeException) {
				System.out.println("yes");
			}
		}
	}
}
