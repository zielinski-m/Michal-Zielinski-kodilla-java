package com.kodilla.good.patterns.challenges.flightService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightBooking {
    private List<Flight> flightList;

    public FlightBooking() {
        flightList = new ArrayList<>();
    }

    public void addFlight(String departureCity, String arrivalCity) {
        Flight flight = new Flight(departureCity, arrivalCity);
        flightList.add(flight);
    }
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flightList);
    }
    public List<Flight> getFlightsFrom(String city) {
        return flightList.stream()
                .filter(flight -> flight.getDepartureCity().equals(city))
                .collect(Collectors.toList());
    }
    public List<Flight> getFlightsTo(String city) {
        return flightList.stream()
                .filter(flight -> flight.getArrivalCity().equals(city))
                .collect(Collectors.toList());
    }
    public List<Flight> getFlightsThrough(String departureCity, String throughCity, String arrivalCity) {
        return flightList.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity))
                .filter(flight -> flight.getArrivalCity().equals(arrivalCity) || flight.getArrivalCity().equals(throughCity))
                .collect(Collectors.toList());
    }
}
