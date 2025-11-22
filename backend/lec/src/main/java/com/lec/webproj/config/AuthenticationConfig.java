package com.lec.webproj.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import com.lec.webproj.provider.FirstAuthenticaionProvider;
import com.lec.webproj.provider.SecondAuthenticaionProvider;
import com.lec.webproj.provider.ThirdAuthenticationProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig {
	private final FirstAuthenticaionProvider firstAuthenticaionProvider;
	//private final SecondAuthenticaionProvider secondAuthenticaionProvider;
	//private final ThirdAuthenticationProvider thirdAuthenticationProvider;
	
	@Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(List.of(
        		firstAuthenticaionProvider
        		//secondAuthenticaionProvider,
        		//thirdAuthenticationProvider
        		));
    }
}
