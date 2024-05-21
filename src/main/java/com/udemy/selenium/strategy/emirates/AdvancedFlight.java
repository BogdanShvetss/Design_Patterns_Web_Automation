package com.udemy.selenium.strategy.emirates;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.udemy.selenium.strategy.emirates.enums.Airport;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class AdvancedFlight implements FlightType {
    SearchPageSelectors searchPageSelectors = new SearchPageSelectors();
    DatePicker datePicker = new DatePicker();

    ElementsCollection departureAirports = $$(By.xpath("//legend[contains(text(), 'Sector')]/following::input[@placeholder='Departure airport']"));
    ElementsCollection arrivalAirports = $$(By.xpath("//legend[contains(text(), 'Sector')]/following::input[@placeholder='Arrival airport']"));
    ElementsCollection departings = $$(By.xpath("//legend[contains(text(), 'Sector')]/following::input[@placeholder='Departing']"));

    @Override
    public void search(Airport departureAirport, Airport arrivalAirport) {
        searchPageSelectors.advancedFlightTab.click();
        this.departureAirports.get(0).sendKeys(departureAirport.getName());
        this.arrivalAirports.get(0).sendKeys(arrivalAirport.getName());
        this.arrivalAirports.get(1).sendKeys(departureAirport.getName());
        departings.get(0).click();
        datePicker.selectTodayDate();
        departings.get(1).click();
        datePicker.selectTodayDate();
        searchPageSelectors.searchButton.click();
    }
}