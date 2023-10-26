package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;

public class Vendors {
    private List<Producent> producentList;

    public Vendors() {
        producentList = new ArrayList<>();
    }

    public void addProducent(Producent producent) {
        producentList.add(producent);
    }

    public boolean ordering(Producent producent, String productName, int quantity) {
        if (producentList.contains(producent)) {
            return producent.process(productName, quantity);
        } else {
            System.out.println("Producent: " + producent.getName() + "is not available at Food2Door app");
            return false;
        }
    }
}
