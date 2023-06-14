package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void BigmacBuilderTest() {

        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Brioche")
                .burgers(3)
                .ingredients("lettuce")
                .sauce("ketchup")
                .ingredients("jalapeno")
                .build();
        System.out.println(bigmac);

        //When
        String whichBun = bigmac.getBun();
        int quantityOfBurgers = bigmac.getBurgers();

        //Then
        assertEquals("Brioche", whichBun);
        assertEquals(3, quantityOfBurgers);
    }
}
