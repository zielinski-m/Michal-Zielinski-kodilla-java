package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightScanner {
    Map <String, Boolean> flySearch = new HashMap<>();

    public FlightScanner() {
        flySearch.put("Warsaw", true);
        flySearch.put("Tokyo", false);
        flySearch.put("Madrid", true);
        flySearch.put("Malmo", true);
        flySearch.put("NYC", true);
        flySearch.put("Washington", false);
    }


    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        boolean departureAirport = flySearch.containsKey(flight.getDepartureAirport()) && flySearch.get(flight.departureAirport);
        boolean arrivalAirport = flySearch.containsKey(flight.getArrivalAirport()) && flySearch.get(flight.arrivalAirport);

        if (!departureAirport) {
            throw new RouteNotFoundException("Departure airport not found");
        }
        if (!arrivalAirport) {
            throw new RouteNotFoundException("Arrival airport not found");
        }
        return true;
    }
}
