package com.udemy.selenium.strategy.payment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class CreditCard implements PaymentOption {
    private SelenideElement cc = $(By.id("cc"));
    private SelenideElement year = $(By.id("year"));
    private SelenideElement cvv = $(By.id("cvv"));

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.cc.sendKeys(paymentDetails.get("cc"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}