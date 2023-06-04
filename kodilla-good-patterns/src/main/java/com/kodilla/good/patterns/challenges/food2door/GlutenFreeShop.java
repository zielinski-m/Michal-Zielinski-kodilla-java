package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop implements Producent {
    public String getName() {
        return "GlutenFreeShop";
    }
    public boolean process(String productName, int quantity) {
        System.out.println("Order: " + productName + " from GlutenFreeShop in quantity of: " + quantity);
        return true;
    }
}
