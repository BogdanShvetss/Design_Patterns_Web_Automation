package com.udemy.selenium.template.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EBaySearchPage {
    private SelenideElement searchBox = $("input[aria-label='Search for anything']");
    private SelenideElement searhButton = $("input[type='submit']");

    public void goTo() {
        open("https://www.ebay.com/");
    }

    public void searchForProduct(String product) {
        searchBox.sendKeys(product);
        searhButton.click();
    }
}
