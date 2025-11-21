package com.lec.webproj.utility;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.lec.webproj.enums.JwtStatus;

@Component
public class JwtUtility {
	private final String SECRET_STRING = "yHgrMdPpYofflnY0HUC5FHZSPzSu4riZmqmO6VcxiiZ";
	private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
    private final long EXP_TIME = 30L;

    public String generateToken(UUID userUUID, LocalDateTime iat) {
    	return Jwts.builder()
    			.header()
	    			.add("alg", "HS256")
	    			.add("typ", "JWT")
	    			.and()
    			.subject(userUUID.toString())
	    			.claim("iat", Timestamp.valueOf(iat))
	    			.claim("exp", Timestamp.valueOf(iat.plusMinutes(EXP_TIME)))
    			.signWith(SECRET_KEY, Jwts.SIG.HS256)
    			.compact();
    }
    
    public Map<String, Object> parseToken(String token) {
    	Map<String, Object> claimMap = new HashMap<>();
    	
    	try {
    		Claims claims = Jwts.parser()
    				.verifyWith(SECRET_KEY)
    				.build()
    				.parseSignedClaims(token)
    				.getPayload();
    		
    		claimMap.put("claims", claims);
    		claimMap.put("status", JwtStatus.VAILD);
    		return claimMap;
    	} catch (JwtException e) {
    		if (e instanceof ExpiredJwtException) {
    			claimMap.put("status", JwtStatus.EXPIRED);
    			return claimMap;
    		} else {
    			claimMap.put("status", JwtStatus.INVALID);
    			return claimMap;
    		}
		}
    }
}

