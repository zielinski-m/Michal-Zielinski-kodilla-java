package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop implements Producent {
    public String getName() {
        return "ExtraFoodShop";
    }
    public boolean process(String productName, int quantity) {
        System.out.println("Order: " + productName + " from ExtraFoodShop in quantity of: " + quantity);
        return true;
    }
}
