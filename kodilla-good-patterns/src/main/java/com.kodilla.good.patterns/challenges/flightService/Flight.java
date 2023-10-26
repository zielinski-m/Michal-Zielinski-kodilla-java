package com.kodilla.good.patterns.challenges.flightService;

import java.util.Objects;

public class Flight {
    private String departureCity;
    private String arrivalCity;

    public Flight(String departureCity, String arrivalCity) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!Objects.equals(departureCity, flight.departureCity))
            return false;
        return Objects.equals(arrivalCity, flight.arrivalCity);
    }

    @Override
    public int hashCode() {
        int result = departureCity != null ? departureCity.hashCode() : 0;
        result = 31 * result + (arrivalCity != null ? arrivalCity.hashCode() : 0);
        return result;
    }
}
