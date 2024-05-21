package com.udemy.selenium.decorator.enums;

public enum Role {
    GUEST("guest"),
    SUPER_USER("superuser"),
    ADMIN("admin");

    private final String role;

    Role(String name) {
        this.role = name;
    }

    public String getName() {
        return role;
    }
}
