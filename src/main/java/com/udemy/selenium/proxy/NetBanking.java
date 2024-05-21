package com.udemy.selenium.proxy;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class NetBanking implements PaymentOption {
    private SelenideElement bank = $(By.id("bank"));
    private SelenideElement accountNumber = $(By.id("acc_number"));
    private SelenideElement pin = $(By.id("pin"));

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        Select select = new Select(bank);

        select.selectByValue(paymentDetails.get("bank"));
        this.accountNumber.sendKeys(paymentDetails.get("accountNumber"));
        this.pin.sendKeys(paymentDetails.get("pin"));
    }
}