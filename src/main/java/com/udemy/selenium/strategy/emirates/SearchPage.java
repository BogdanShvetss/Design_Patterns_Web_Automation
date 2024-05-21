package com.udemy.selenium.strategy.emirates;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.udemy.selenium.strategy.emirates.enums.Airport;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    FlightType flightType;

    private SelenideElement acceptCookiesButton = $("#onetrust-accept-btn-handler");
    private SelenideElement newSearchButton = $("a[onclick='logSearchEvent()']");

    public void goTo() {
        Selenide.open("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");
        acceptCookiesButton.click();
        newSearchButton.click();
    }

    public SearchPage setSearchStrategy(FlightType flightType) {
        this.flightType = flightType;
        return this;
    }

    public void searchFlight(Airport departureAirport, Airport arrivalAirport) {
        this.flightType.search(departureAirport, arrivalAirport);
    }
}