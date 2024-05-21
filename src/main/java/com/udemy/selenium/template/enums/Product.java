package com.udemy.selenium.template.enums;

public enum Product {
    WATCH("Garmin Fenix 7 Pro");

    private final String name;

    Product(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
