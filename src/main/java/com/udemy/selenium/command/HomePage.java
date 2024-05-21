package com.udemy.selenium.command;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private SelenideElement infoButton = $("div[class='button-box'] button[class*='btn-info']");
    private SelenideElement infoAlert = $("div[class*='jq-icon-info']");
    private SelenideElement warningButton = $("div[class='button-box'] button[class*='btn-warning']");
    private SelenideElement warningAlert = $("div[class*='jq-icon-warning']");
    private SelenideElement successButton = $("div[class='button-box'] button[class*='btn-success']");
    private SelenideElement successAlert = $("div[class*='jq-icon-success']");
    private SelenideElement dangerButton = $("div[class='button-box'] button[class*='btn-danger']");
    private SelenideElement dangerAlert = $("div[class*='jq-icon-error']");

    private SelenideElement dismissalSuccessAlert = $(By.xpath("//h4[text()='Dissmissal Alert']/following-sibling::div[@class='alert alert-success']"));
    private SelenideElement dismissalDangerAlert = $(By.xpath("//h4[text()='Dissmissal Alert']/following-sibling::div[@class='alert alert-danger']"));
    private SelenideElement dismissalWarningAlert = $(By.xpath("//h4[text()='Dissmissal Alert']/following-sibling::div[@class='alert alert-warning']"));
    private SelenideElement dismissalInfoAlert = $(By.xpath("//h4[text()='Dissmissal Alert']/following-sibling::div[@class='alert alert-info']"));

    public void goTo() {
        open("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
                new NotificationValidator(infoButton, infoAlert),
                new NotificationValidator(warningButton, warningAlert),
                new NotificationValidator(successButton, successAlert),
                new NotificationValidator(dangerButton, dangerAlert),
                new DismissalAlertValidator(dismissalSuccessAlert),
                new DismissalAlertValidator(dismissalDangerAlert),
                new DismissalAlertValidator(dismissalWarningAlert),
                new DismissalAlertValidator(dismissalInfoAlert)
        );
    }
}