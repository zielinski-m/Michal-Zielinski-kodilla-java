package com.kodilla.exception.test;

public class FlightScannerExceptionHandling {

    public static void main(String[] args) {
        FlightScanner flightScanner = new FlightScanner();

        Flight flightNoException = new Flight("Warsaw", "Madrid");
        Flight flightWithException = new Flight("Tokyo", "NYC");
        Flight flightWith2Exception = new Flight("NYC", "Tokyo");


        try {
            flightScanner.findFlight(flightNoException);
            System.out.println("Flight founded");
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The program ended \n");
        }

        try {
            flightScanner.findFlight(flightWith2Exception);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The program ended \n");
        }

        try {
            flightScanner.findFlight(flightWithException);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The program ended \n");
        }
    }
}
