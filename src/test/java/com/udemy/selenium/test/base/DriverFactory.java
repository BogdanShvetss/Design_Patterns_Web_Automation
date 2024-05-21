package com.udemy.selenium.test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.SkipException;

public class DriverFactory {

    public static WebDriver getDriver(Driver driver, boolean headless) {
        WebDriver webDriver = null;
        switch (driver) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en-GB");
                options.addArguments("--incognito");

                if (headless) {
                    options.addArguments("--headless=new");
                }

                webDriver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("intl.accept_languages", "en-us");

                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                webDriver = new FirefoxDriver(firefoxOptions);
            }
            default -> {
                throw new SkipException(String.format("Browser - %s isn't supported", driver.name()));
            }
        }
        return webDriver;
    }
}