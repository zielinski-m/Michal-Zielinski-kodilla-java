package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Test
    void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double resultAdd = calculator.add(2, 4);
        double resultSub = calculator.sub(2, 2);
        double resultMul = calculator.mul(5, 4);
        double resultDiv = calculator.div(10, 5);

        //Then
        assertEquals(6, resultAdd);
        assertEquals(0, resultSub);
        assertEquals(20, resultMul);
        assertEquals(2, resultDiv);

    }
}
