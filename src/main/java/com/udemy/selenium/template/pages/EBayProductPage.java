package com.udemy.selenium.template.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EBayProductPage {
    private SelenideElement butItNowButton = $("a[data-testid='ux-call-to-action']");

    public void buy() {
        butItNowButton.click();
    }
}