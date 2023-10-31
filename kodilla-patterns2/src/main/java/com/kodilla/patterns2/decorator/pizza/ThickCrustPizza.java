package com.kodilla.patterns2.decorator.pizza;

public class ThickCrustPizza extends AbstractPizzaOrderDecorator {

    public ThickCrustPizza(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.00;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " ,double thick crust";
    }
}
