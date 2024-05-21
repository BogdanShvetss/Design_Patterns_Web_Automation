package com.udemy.selenium.command;

import com.codeborne.selenide.SelenideElement;

public class DismissalAlertValidator extends ElementValidator {
    private SelenideElement dismissalAlert;

    public DismissalAlertValidator(SelenideElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        boolean appearanceState = dismissalAlert.isDisplayed();
        this.dismissalAlert.$("button[class='close']").click();
        boolean disappearanceState = dismissalAlert.isDisplayed();

        return appearanceState && (!disappearanceState);
    }
}