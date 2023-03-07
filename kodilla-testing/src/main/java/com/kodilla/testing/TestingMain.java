package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;

import java.util.Random;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculate = new Calculator(20, 15);

        int addResult = calculate.adding();
        int subtractResult = calculate.subtract();

        if(addResult == (calculate.getA() + calculate.getB())) {
            System.out.println("test OK");
        } else { System.out.println("Error!");
        }

        if(subtractResult == (calculate.getA() - calculate.getB())) {
            System.out.println("test OK");
        } else { System.out.println("Error!");
        }
    }
}
