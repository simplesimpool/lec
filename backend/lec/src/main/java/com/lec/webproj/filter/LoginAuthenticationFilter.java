package com.lec.webproj.filter;

import java.io.IOException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lec.webproj.dto.LoginDTO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoginAuthenticationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		System.out.println("this is loginauthenticaionfilter");
		return;
//		filterChain.doFilter(request, response);
//		String httpMethod = request.getMethod();
//		String contentType = request.getContentType();
//
//		boolean isPostMethod = httpMethod.equals("POST");
//		boolean isAllowedContentType = contentType.equals("application/x-www-form-urlencoded");
//		
//		LoginDTO dto = LoginDTO.builder()
//				.userId(request.getParameter("userId"))
//				.userPw(request.getParameter("userPw"))
//				.build();
//		
//		
//		if (!isPostMethod) {
//			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("application/json");
//			response.getWriter().write("{\"error\":\"잘못된 메서드 요청\"}");
//			return;
//		} else if (dto.isNullDataExists()) {
//			
//			System.out.println("reason2");
//			return;
//		} else {
//			System.out.println("reason3");
//			filterChain.doFilter(request, response);
//		}
	}
}