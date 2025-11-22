package com.lec.webproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
	private final String SERVER_IP = "localhost";
	private final String SERVER_PORT = "5173";
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry
	            .addMapping("/**")
	            .allowedOrigins(String.format("http://%s:%s", SERVER_IP, SERVER_PORT))
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	            .allowCredentials(true) 
	            .allowedHeaders("*")
	            .maxAge(3600);
	        }
        };
    }
}
