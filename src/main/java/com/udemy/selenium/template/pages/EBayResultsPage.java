package com.udemy.selenium.template.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EBayResultsPage {
    private ElementsCollection products = $$("li[id*='item'] img");
    private SelenideElement butItNowFilter = $("ul[class*='fake-tabs__items'] > li:last-of-type");

    public void selectProduct() {
        butItNowFilter.click();
        products.get(0).click();
        Selenide.switchTo().window(1);
    }
}
