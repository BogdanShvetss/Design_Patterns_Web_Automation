package com.udemy.selenium.srp.common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class SearchWidget extends AbstractComponent {

    SelenideElement searchBox = $(By.name("q"));

    public void enter(String keyword) {
        this.searchBox.clear();

        for (char c : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(c + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        return Selenide.Wait().until(d -> this.searchBox.isDisplayed());
    }
}