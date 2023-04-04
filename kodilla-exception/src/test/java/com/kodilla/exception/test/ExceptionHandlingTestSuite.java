package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ExceptionHandlingTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        //when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.0));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.0));
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2.5));
    }
}
