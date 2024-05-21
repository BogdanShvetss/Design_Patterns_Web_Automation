package com.udemy.selenium.srp.result;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.udemy.selenium.srp.common.AbstractComponent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationBar extends AbstractComponent {

    private SelenideElement bar = $("#hdtb");
    private SelenideElement images = $(By.linkText("Images"));
    private SelenideElement news = $(By.linkText("News"));

    public void goToImages() {
        this.images.click();
    }

    public void goToNews() {
        this.news.click();
    }

    @Override
    public boolean isDisplayed() {
        return Selenide.Wait().until(d -> this.bar.isDisplayed());
    }
}