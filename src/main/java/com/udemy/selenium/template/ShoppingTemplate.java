package com.udemy.selenium.template;

public abstract class ShoppingTemplate {
    public abstract void launchSite();

    public abstract void searchForProduct();

    public abstract void selectProduct();

    public abstract void buy();

    public void shop() {
        launchSite();
        searchForProduct();
        selectProduct();
        buy();
    }
}