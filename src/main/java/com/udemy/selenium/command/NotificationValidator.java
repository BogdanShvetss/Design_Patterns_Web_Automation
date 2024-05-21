package com.udemy.selenium.command;

import com.codeborne.selenide.SelenideElement;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator {
    private SelenideElement button;
    private SelenideElement notification;

    public NotificationValidator(SelenideElement button, SelenideElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean appearanceState = this.notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean disappearanceState = this.notification.isDisplayed();

        return appearanceState && (!disappearanceState);
    }
}