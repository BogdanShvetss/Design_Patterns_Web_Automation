package com.udemy.selenium.test.command;

import com.udemy.selenium.command.ElementValidator;
import com.udemy.selenium.command.HomePage;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeTest
    public void beforeTest() {
        this.homePage = new HomePage();
    }

    @Test(dataProvider = "getData")
    public void homePageTest(ElementValidator elementValidator) {
        homePage.goTo();
        Assert.assertTrue(elementValidator.validate());
    }

    @DataProvider(name = "getData", parallel = true)
    public Iterator<Object[]> getData() {
        return homePage.getElementValidators().stream()
                .map(v -> new Object[]{v})
                .iterator();
    }
}