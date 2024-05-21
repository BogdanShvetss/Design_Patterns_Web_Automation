package com.udemy.selenium.strategy.payment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserInformation {
    private SelenideElement firstName = $(By.id("fn"));
    private SelenideElement lastName = $(By.id("ln"));
    private SelenideElement email = $(By.id("email"));

    public void enterDetails(String firstName, String lastName, String email) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
    }
}