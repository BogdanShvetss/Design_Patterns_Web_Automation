package com.udemy.selenium.proxy;

import com.codeborne.selenide.Selenide;

import java.util.Map;

public class PaymentScreen {
    private UserInformation userInformation = new UserInformation();
    private OrderComponent orderComponent;
    private PaymentOption paymentOption;

    public PaymentScreen() {
        this.orderComponent = new OrderComponentProxy();
    }

    public void goTo() {
        Selenide.open("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public OrderComponent getOrder() {
        return orderComponent;
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