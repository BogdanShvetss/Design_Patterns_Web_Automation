package com.udemy.selenium.test.factory;

import com.udemy.selenium.factory.GoogleFactory;
import com.udemy.selenium.factory.GooglePage;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {
    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {
        googlePage = GoogleFactory.get(language);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultsCount = this.googlePage.getResultsCount();

        System.out.println(resultsCount);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[][]{{"ENG", "selenium"}, {"UKR", "selenium"}};

        return data;
    }
}