package com.udemy.selenium.strategy.emirates;

import com.codeborne.selenide.SelenideElement;
import com.udemy.selenium.strategy.emirates.enums.Airport;

import static com.codeborne.selenide.Selenide.$;

public class ReturnFlight implements FlightType {
    SearchPageSelectors searchPageSelectors = new SearchPageSelectors();
    DatePicker datePicker = new DatePicker();

    SelenideElement departureAirport = $("input[placeholder='Departure airport']");
    SelenideElement arrivalAirport = $("input[placeholder='Arrival airport']");
    SelenideElement departing = $("input[placeholder='Departing']");
    SelenideElement returning = $("input[placeholder='Returning']");

    @Override
    public void search(Airport departureAirport, Airport arrivalAirport) {
        searchPageSelectors.returnFlightTab.click();
        this.departureAirport.sendKeys(departureAirport.getName());
        departing.click();
        datePicker.selectTodayDate();
        this.arrivalAirport.sendKeys(arrivalAirport.getName());
        returning.click();
        datePicker.selectTomorrowDate();
        searchPageSelectors.searchButton.click();
    }
}