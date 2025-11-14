package com.lec.webproj.enums;

public enum UserRole {
	USER("USER"),
	ADMIN("ADMIN");
	
	private final String role;
	
	UserRole(String role) {
        this.role = role;
    }

    // getter
    public String getRole() {
        return role;
    }
}
