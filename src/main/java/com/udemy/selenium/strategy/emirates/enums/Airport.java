package com.udemy.selenium.strategy.emirates.enums;

public enum Airport {
    NEW_YORK("New York (NYC)"),
    LONDON("Londonderry Airport (LDY)");

    private final String name;

    Airport(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}