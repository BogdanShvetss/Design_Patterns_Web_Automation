package com.udemy.selenium.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GoogleFactory {

    private static final Supplier<GooglePage> ENG = () -> new GoogleEnglish();
    private static final Supplier<GooglePage> UKR = () -> new GoogleUkrainian();

    private static final Map<String, Supplier<GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENG", ENG);
        MAP.put("UKR", UKR);
    }

    public static GooglePage get(String language) {
        return MAP.get(language).get();
    }
}