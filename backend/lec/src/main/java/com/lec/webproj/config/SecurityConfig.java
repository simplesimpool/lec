package com.lec.webproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lec.webproj.filter.JwtAuthenticationFilter;
import com.lec.webproj.filter.LoginAuthenticationFilter;
import com.lec.webproj.filter.LogoutFilter;
import com.lec.webproj.service.UserService;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final LoginAuthenticationFilter loginAuthenticationFilter;
	private final LogoutFilter logoutFilter;
	
	@Bean
    public SecurityFilterChain loginSecurityFilterChain(HttpSecurity http) throws Exception {
		http
        .securityMatcher("/api/login")
        .cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form.disable())
        .httpBasic(basic -> basic.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
        		.anyRequest().authenticated()
        )
        .addFilterBefore(loginAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
	}
	
	@Bean
    public SecurityFilterChain logoutSecurityFilterChain(HttpSecurity http) throws Exception {
		http
        .securityMatcher("/api/logout")
        .cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form.disable())
        .httpBasic(basic -> basic.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
        		.anyRequest().authenticated()
        )
        .addFilterBefore(logoutFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
	}
	
	@Bean
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
		http
        .securityMatcher("**")
        .cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form.disable())
        .httpBasic(basic -> basic.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
        		.requestMatchers(HttpMethod.POST, "/api/users").permitAll()
        		.anyRequest().authenticated()
        )
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
	}
}
