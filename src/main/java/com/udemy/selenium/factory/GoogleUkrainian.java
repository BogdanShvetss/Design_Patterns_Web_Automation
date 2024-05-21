package com.udemy.selenium.factory;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class GoogleUkrainian extends GoogleEnglish {
    private SelenideElement ukrainianLanguage = $("div[id*='output-page'] a");
    private SelenideElement keyboardButton = $(By.xpath("//img[contains(@src,'tia')]/parent::span"));
    private SelenideElement keyboard = $(By.id("kbd"));

    @Override
    public void launchSite() {
        Selenide.open("https://www.google.com.ua/");
        this.ukrainianLanguage.click();
    }

    @Override
    public void search(String keyword) {
        Selenide.Wait().until(d -> this.keyboardButton.isDisplayed());
        this.keyboardButton.click();
        Selenide.Wait().until(d -> this.keyboard.isDisplayed());
        super.search(keyword);
    }
}