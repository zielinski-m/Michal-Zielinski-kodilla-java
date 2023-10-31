package com.kodilla.patterns2.decorator.pizza;

public class JalapenoDecorator extends AbstractPizzaOrderDecorator {

    public JalapenoDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.00;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + " ,jalapeno peppers extra spicy";
    }
}
