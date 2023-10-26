package com.kodilla.good.patterns.challenges.food2door;

public class Main {
    public static void main(String[] args) {
        Vendors vendors = new Vendors();

        Producent extraFoodShop = new ExtraFoodShop();
        vendors.addProducent(extraFoodShop);

        Producent healthyShop = new HealthyShop();
        vendors.addProducent(healthyShop);

        Producent glutenFreeShop = new GlutenFreeShop();
        vendors.addProducent(glutenFreeShop);

        // implementation of sample order
        vendors.ordering(extraFoodShop, "Pad Thai", 1);
        vendors.ordering(healthyShop, "Angus Steak", 4);
        vendors.ordering(glutenFreeShop, "GF - Flour 1kg", 2);
    }
}
