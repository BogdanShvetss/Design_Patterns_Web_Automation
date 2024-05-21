package com.udemy.selenium.proxy;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrderComponentReal implements OrderComponent {
    private SelenideElement buyNow = $(By.id("buy"));
    private SelenideElement orderNumber = $(By.id("ordernumber"));

    @Override
    public String placeOrder() {
        this.buyNow.click();
        return orderNumber.getText();
    }
}