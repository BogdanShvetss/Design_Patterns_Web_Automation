package com.udemy.selenium.test.decorator;

import com.udemy.selenium.decorator.DashboardPage;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {
    private DashboardPage dashboardPage;

    @BeforeTest
    public void beforeTest() {
        dashboardPage = new DashboardPage();
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashboardPage> role) {
        dashboardPage.goTo();
        role.accept(dashboardPage);
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{
                {Decorators.guestPage},
                {Decorators.superUserPage},
                {Decorators.adminUserPage}
        };
    }
}