package com.udemy.selenium.test.strategy;

import com.udemy.selenium.strategy.emirates.*;
import com.udemy.selenium.strategy.emirates.enums.Airport;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmiratesTest extends BaseTest {
    SearchPage searchPage;

    @BeforeMethod()
    public void beforeMethod() {
        searchPage = new SearchPage();
        searchPage.goTo();
    }

    @Test(dataProvider = "getData")
    public void flightTest(FlightType flightType, Airport departureAirport, Airport arrivalAirport) {
        searchPage.setSearchStrategy(flightType);
        searchPage.searchFlight(departureAirport, arrivalAirport);
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{
                {new ReturnFlight(), Airport.NEW_YORK, Airport.LONDON},
                {new OneWayFlight(), Airport.NEW_YORK, Airport.LONDON},
                {new AdvancedFlight(), Airport.NEW_YORK, Airport.LONDON}
        };
    }
}