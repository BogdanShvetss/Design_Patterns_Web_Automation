package com.udemy.selenium.template.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AmazonSearchPage {
    private SelenideElement searchBox = $("#twotabsearchtextbox");
    private SelenideElement searchButton = $("input[type='submit']");


    public void goTo() {
        open("https://www.amazon.com/");
    }

    public void searchForProduct(String product) {
        searchBox.sendKeys(product);
        searchButton.click();
    }
}
