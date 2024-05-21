package com.udemy.selenium.test.executearound;

import com.udemy.selenium.executearound.MainPage;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage();
    }

    @Test
    public void frameTest() {
        mainPage.goTo();

        mainPage.onFrameA(a -> {
            a.setFirstName("John");
            a.setLastName("Cena");
            a.setAddress("West Newbury");
        });

        mainPage.onFrameC(c -> c.setMessageTextArea("You can't see me!"));
    }
}