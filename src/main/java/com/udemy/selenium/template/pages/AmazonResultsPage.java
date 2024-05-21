package com.udemy.selenium.template.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class AmazonResultsPage {
    private ElementsCollection products = $$("div[class*='s-product-image-container']");

    public void selectProduct() {
        products.get(0).click();
    }
}
