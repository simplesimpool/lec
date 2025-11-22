package com.lec.webproj.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lec.webproj.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private final AuthenticationManager authenticationManager;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		System.out.println("this is jwt authenticaionfilter");
		boolean isAccessTokenFound = false;
		
		
//		for (Cookie cookie : request.getCookies()) {
//			if (cookie.getName().equals("accessToken")) {
//				isAccessTokenFound = true;
//				break;
//			}
//		}
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("userId1", "userPw1");
		Authentication authentication = authenticationManager.authenticate(token);
		
		filterChain.doFilter(request, response);
	}
}