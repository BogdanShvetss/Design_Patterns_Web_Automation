package com.udemy.selenium.strategy.payment;

import com.codeborne.selenide.Selenide;

import java.util.Map;

public class PaymentScreen {
    private UserInformation userInformation  = new UserInformation();
    private Order order = new Order();
    private PaymentOption paymentOption;

    public void goTo() {
        Selenide.open("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public Order getOrder() {
        return order;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentOption.enterPaymentInformation(paymentDetails);
    }
}