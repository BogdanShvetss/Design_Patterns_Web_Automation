package com.udemy.selenium.template;

import com.udemy.selenium.template.pages.EBayProductPage;
import com.udemy.selenium.template.pages.EBayResultsPage;
import com.udemy.selenium.template.pages.EBaySearchPage;

public class EBayShopping extends ShoppingTemplate {
    private String product;
    EBaySearchPage eBaySearchPage;
    EBayResultsPage eBayResultsPage;
    EBayProductPage eBayProductPage;

    public EBayShopping(String product) {
        this.product = product;
        this.eBaySearchPage = new EBaySearchPage();
        this.eBayResultsPage = new EBayResultsPage();
        this.eBayProductPage = new EBayProductPage();
    }

    @Override
    public void launchSite() {
        eBaySearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        eBaySearchPage.searchForProduct(product);
    }

    @Override
    public void selectProduct() {
        eBayResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        eBayProductPage.buy();
    }
}