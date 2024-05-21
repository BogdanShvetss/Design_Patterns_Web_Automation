package com.udemy.selenium.srp.result;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.udemy.selenium.srp.common.AbstractComponent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ResultStats extends AbstractComponent {
    private SelenideElement stat = $(By.id("result-stats"));

    public String getStat() {
        return this.stat.getText();
    }

    @Override
    public boolean isDisplayed() {
        return Selenide.Wait().until(d -> stat.isDisplayed());
    }
}