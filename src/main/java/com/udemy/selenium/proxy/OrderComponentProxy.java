package com.udemy.selenium.proxy;

import com.udemy.selenium.proxy.enums.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {
    private static final List<Environment> EXCLUDED = Arrays.asList(Environment.PROD, Environment.STAGING);
    private OrderComponent orderComponent;

    public OrderComponentProxy() {
        Environment env = Environment.valueOf(System.getProperty("env").toUpperCase());

        boolean isEnvironmentExcluded = EXCLUDED.stream().anyMatch(s -> s.equals(env));

        if (!isEnvironmentExcluded) {
            this.orderComponent = new OrderComponentReal();
        }
    }

    @Override
    public String placeOrder() {
        if (Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        } else {
            return "Skipped";
        }
    }
}