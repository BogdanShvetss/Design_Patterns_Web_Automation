package com.udemy.selenium.template;

import com.udemy.selenium.template.pages.AmazonProductPage;
import com.udemy.selenium.template.pages.AmazonResultsPage;
import com.udemy.selenium.template.pages.AmazonSearchPage;

public class AmazonShopping extends ShoppingTemplate {
    private String product;
    AmazonSearchPage amazonSearchPage;
    AmazonResultsPage amazonResultsPage;
    AmazonProductPage amazonProductPage;

    public AmazonShopping(String product) {
        this.product = product;
        this.amazonSearchPage = new AmazonSearchPage();
        this.amazonResultsPage = new AmazonResultsPage();
        this.amazonProductPage = new AmazonProductPage();
    }

    @Override
    public void launchSite() {
        amazonSearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        amazonSearchPage.searchForProduct(product);
    }

    @Override
    public void selectProduct() {
        amazonResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        amazonProductPage.buy();
    }
}