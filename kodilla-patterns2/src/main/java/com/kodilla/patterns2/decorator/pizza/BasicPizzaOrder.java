package com.kodilla.patterns2.decorator.pizza;

public class BasicPizzaOrder implements PizzaOrder {

    public double getCost() {
        return 20.00;
    }

    public String getDesc() {
        return "Pizza with tomato sauce and cheese";
    }
}
