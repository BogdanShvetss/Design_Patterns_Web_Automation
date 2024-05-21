package com.udemy.selenium.template.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AmazonProductPage {
    private SelenideElement addToList = $("a[title='Add to List']");

    public void buy() {
        addToList.click();
    }
}