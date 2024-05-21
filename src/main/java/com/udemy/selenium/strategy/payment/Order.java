package com.udemy.selenium.strategy.payment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Order {
    private SelenideElement buyNow = $(By.id("buy"));
    private SelenideElement orderNumber = $(By.id("ordernumber"));

    public String placeOrder() {
        this.buyNow.click();
        return orderNumber.getText();
    }
}