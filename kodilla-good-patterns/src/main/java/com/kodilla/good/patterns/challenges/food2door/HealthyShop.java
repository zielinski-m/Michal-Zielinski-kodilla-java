package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop implements Producent {
    public String getName() {
        return "HealthyShop";
    }
    public boolean process(String productName, int quantity) {
        System.out.println("Order: " + productName + " from HealthyShop in quantity of: " + quantity);
        return true;
    }
}
