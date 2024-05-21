package com.udemy.selenium.factory;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

class GoogleEnglish extends GooglePage {
    private SelenideElement searchBox = $(By.name("q"));
    private SelenideElement searchButton = $(By.name("btnK"));
    private ElementsCollection resultTitles = $$("h3[class]");

    @Override
    public void launchSite() {
        Selenide.open("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        for (char c : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(c + "");
        }

        Selenide.Wait().until(d -> this.searchButton.isDisplayed());
        this.searchButton.click();
    }

    @Override
    public int getResultsCount() {
        Selenide.Wait().until((d) -> this.resultTitles.size() > 1);
        return resultTitles.size();
    }
}