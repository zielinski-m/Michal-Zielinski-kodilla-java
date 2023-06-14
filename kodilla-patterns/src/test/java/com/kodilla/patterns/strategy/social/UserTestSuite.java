package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {

        //Given
        User adam = new Millenials("Adam");
        User paul = new YGeneration("Paul");
        User john = new ZGeneration("John");

        //When
        String adamPub = adam.socialApp();
        String paulPub = paul.socialApp();
        String johnPub = john.socialApp();
        System.out.println("Adam favourite SocialApp: " + adamPub);
        System.out.println("Paul favourite SocialApp: " + paulPub);
        System.out.println("John favourite SocialApp: " + johnPub);

        //Then
        assertEquals("Facebook", adamPub);
        assertEquals("SnapChat", paulPub);
        assertEquals("Twitter", johnPub);
    }

    @Test
    void testIndividualSharingStrategy() {

        //Given
        User paul = new YGeneration("Paul");

        //When
        String paulPub = paul.socialApp();
        System.out.println("Paul favourite SocialApp: " + paulPub);
        paul.setSocialPublisher(new TwitterPublisher());
        paulPub = paul.socialApp();
        System.out.println("Paul new favourite SocialApp: " + paulPub);
    }
}
