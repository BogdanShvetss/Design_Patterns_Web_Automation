package com.udemy.selenium.strategy.emirates;

import com.codeborne.selenide.SelenideElement;
import com.udemy.selenium.strategy.emirates.enums.Airport;

import static com.codeborne.selenide.Selenide.$;

public class OneWayFlight implements FlightType {
    SearchPageSelectors searchPageSelectors = new SearchPageSelectors();
    DatePicker datePicker = new DatePicker();

    SelenideElement departureAirport = $("input[placeholder='Departure airport']");
    SelenideElement arrivalAirport = $("input[placeholder='Arrival airport']");
    SelenideElement departing = $("input[placeholder='Departing']");

    @Override
    public void search(Airport departureAirport, Airport arrivalAirport) {
        searchPageSelectors.oneWayFlightTab.click();
        this.departureAirport.sendKeys(departureAirport.getName());
        departing.click();
        datePicker.selectTodayDate();
        this.arrivalAirport.sendKeys(arrivalAirport.getName());
        searchPageSelectors.searchButton.click();
    }
}
