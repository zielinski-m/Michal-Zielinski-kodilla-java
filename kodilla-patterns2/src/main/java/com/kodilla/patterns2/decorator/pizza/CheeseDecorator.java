package com.kodilla.patterns2.decorator.pizza;

public class CheeseDecorator extends AbstractPizzaOrderDecorator {
    public CheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.00;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " ,extra cheese";
    }

}
