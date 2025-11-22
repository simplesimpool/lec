package com.lec.webproj.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class FirstAuthenticaionProvider implements AuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        // 간단 예시: 하드코딩 인증
        if ("userId1".equals(username) && "userPw1".equals(password)) {
            return authentication;
        }

        return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}