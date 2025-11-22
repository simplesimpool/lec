package com.lec.webproj.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class SecondAuthenticaionProvider implements AuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("second authenticaion provider");
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
