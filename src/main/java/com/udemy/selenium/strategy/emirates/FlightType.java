package com.udemy.selenium.strategy.emirates;

import com.udemy.selenium.strategy.emirates.enums.Airport;

public interface FlightType {
    public void search(Airport departureAirport, Airport arrivalAirport);
}
