package com.base_security.dk_security.models;

public enum ApplicationUserPermission {
    IDEA_READ("idea:read"),
    IDEA_WRITE("idea:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

	private ApplicationUserPermission(String permission) {
		this.permission = permission;
    }

	public String getPermission() {
		return permission;
	}
    
    

    
}
