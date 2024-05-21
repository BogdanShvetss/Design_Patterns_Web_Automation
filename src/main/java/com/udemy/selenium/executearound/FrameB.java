package com.udemy.selenium.executearound;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FrameB {
    private SelenideElement firstNameInput = $("[name='fn']");
    private SelenideElement lastNameInput = $("[name='ln']");
    private SelenideElement addressInput = $("[name='addr']");
    private SelenideElement messageTextArea = $("#area");

    public void setFirstName(String firstName) {
        this.firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
    }

    public void setAddress(String address) {
        this.addressInput.sendKeys(address);
    }

    public void setMessageTextArea(String message) {
        this.messageTextArea.sendKeys(message);
    }
}
