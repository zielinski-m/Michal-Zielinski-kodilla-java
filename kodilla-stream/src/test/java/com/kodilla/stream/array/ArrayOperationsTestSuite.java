package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {

        //Given
        int[] testArrayOfNumbers = new int[] {  21, 45, 54, 46, 7, 58, 54, 1, 6, 11, 25, 31, 69,
                                                47, 81, 1, 0, 55, 21, 7 };

        //When
        Double providedResult = ArrayOperations.getAverage(testArrayOfNumbers);
        Double expectedResult = Arrays.stream(testArrayOfNumbers).average().getAsDouble();

        //Then
        assertEquals(expectedResult, providedResult);
    }
}
