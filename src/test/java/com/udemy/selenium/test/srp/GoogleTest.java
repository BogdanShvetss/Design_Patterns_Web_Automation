package com.udemy.selenium.test.srp;

import com.udemy.selenium.srp.main.GoogleMainPage;
import com.udemy.selenium.srp.result.GoogleResultsPage;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
    private GoogleMainPage googleMainPage;
    private GoogleResultsPage googleResultsPage;

    @BeforeTest
    public void setupPages() {
        this.googleMainPage = new GoogleMainPage();
        this.googleResultsPage = new GoogleResultsPage();
    }

    @Test(dataProvider = "getData")
    public void googleWorkflow(String keyword, int index) {
        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());
        googleMainPage.getSearchWidget().enter(keyword);

        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());
        googleResultsPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultsPage.getNavigationBar().isDisplayed());

        googleResultsPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultsPage.getSearchSuggestion().isDisplayed());

        googleResultsPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultsPage.getNavigationBar().goToNews();
        System.out.println(googleResultsPage.getResultStats().getStat());
    }

    @DataProvider()
    public Object[][] getData() {
        return new Object[][]{
                {"Java", 3},
                {"Docker", 2},
        };
    }
}