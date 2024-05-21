package com.udemy.selenium.strategy.emirates;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPageSelectors {
    SelenideElement searchButton = $(By.xpath("//a/span[text()='Search']"));
    SelenideElement returnFlightTab = $("label[for='returnSearch']");
    SelenideElement oneWayFlightTab = $("label[for*='onewaySearch']");
    SelenideElement advancedFlightTab = $("label[for*='multipleSearch']");
}