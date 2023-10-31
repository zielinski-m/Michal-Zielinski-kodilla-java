package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();

        //When
        double theCost = theOrder.getCost();

        //Then
        assertEquals(20, theCost);
    }

    @Test
    void testPizzaOrderWithJalapenosAndExtraCheese() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new JalapenoDecorator(theOrder);

        //When
        double pizzaPrice = theOrder.getCost();
        String pizzaDesc = theOrder.getDesc();

        //Then
        assertEquals(28, pizzaPrice);
        assertEquals("Pizza with tomato sauce and cheese ,extra cheese ,jalapeno peppers extra spicy", pizzaDesc);
    }

    @Test
    void testPizzaOrderWithAllToppingsAndThickCrust() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new JalapenoDecorator(theOrder);
        theOrder = new ThickCrustPizza(theOrder);

        //When
        double pizzaPrice = theOrder.getCost();
        String pizzaDesc = theOrder.getDesc();

        //Then
        assertEquals(43, pizzaPrice);
        assertEquals("Pizza with tomato sauce and cheese ,extra cheese ,extra cheese ,jalapeno peppers extra spicy ,double thick crust", pizzaDesc);

    }
}
