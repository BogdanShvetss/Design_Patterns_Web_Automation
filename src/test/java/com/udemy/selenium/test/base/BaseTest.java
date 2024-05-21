package com.udemy.selenium.test.base;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void setUpWebDriver() {
        webDriver = DriverFactory.getDriver(Driver.valueOf(System.getProperty("browser")), Boolean.valueOf(System.getProperty("headless")));
        WebDriverRunner.setWebDriver(webDriver);
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverRunner.closeWindow();
    }

    @AfterTest()
    public void quitDriver() {
        WebDriverRunner.closeWebDriver();
    }
}