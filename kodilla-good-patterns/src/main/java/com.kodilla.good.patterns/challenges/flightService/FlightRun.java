package com.kodilla.good.patterns.challenges.flightService;

import java.util.List;

public class FlightRun {
    public static void main(String[] args) {
        FlightBooking flightBooking = new FlightBooking();

        flightBooking.addFlight("Gdansk", "Wroclaw");
        flightBooking.addFlight("Gdansk", "Krakow");
        flightBooking.addFlight("Krakow", "Wroclaw");
        flightBooking.addFlight("Warsaw", "Krakow");

        List<Flight> allFlights = flightBooking.getAllFlights();
        System.out.println("\n All flights");
        for (Flight flight : allFlights) {
            System.out.println(flight.getDepartureCity() + " -> " + flight.getArrivalCity());
        }

        List<Flight> flightsFromGdansk = flightBooking.getFlightsFrom("Gdansk");
        System.out.println("\n Flights from Gdansk: ");
        for (Flight flight : flightsFromGdansk) {
            System.out.println(flight.getDepartureCity() + " --> " + flight.getArrivalCity());
        }

        List<Flight> flightsToKrakow = flightBooking.getFlightsTo("Krakow");
        System.out.println("\n Flight to Krakow: ");
        for (Flight flight : flightsToKrakow) {
            System.out.println(flight.getDepartureCity() + " -> " + flight.getArrivalCity());
        }

        List<Flight> flightsThroughKrakow = flightBooking.getFlightsThrough("Gdansk", "Krakow", "Wroclaw");
        System.out.println("\n Flights from Gdansk through Krakow to Wroclaw:");
        for (Flight flight : flightsThroughKrakow) {
            System.out.println(flight.getDepartureCity() + " -> " + flight.getArrivalCity());
        }
    }
}
