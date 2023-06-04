package com.kodilla.good.patterns.challenges.food2door;

public interface Producent {
    String getName();
    boolean process(String productName, int quantity);
}
