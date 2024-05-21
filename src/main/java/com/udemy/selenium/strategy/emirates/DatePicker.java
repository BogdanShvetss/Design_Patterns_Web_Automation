package com.udemy.selenium.strategy.emirates;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DatePicker {
    private SelenideElement todayDate = $("a[id*='day'][class*='active']");

    public void selectTodayDate() {
        todayDate.click();
    }

    public void selectTomorrowDate() {
        todayDate.parent().sibling(0).click();
    }
}
