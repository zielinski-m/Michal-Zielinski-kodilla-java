package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionTestSuite {
    @BeforeEach public void before() {System.out.println("Collection test suite: begin ");}
    @AfterEach public void after() {System.out.println("Test case: end ");}

    @DisplayName("Odd numbers exterminator test for empty list")

    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminatorForEmptyList = new OddNumbersExterminator();
        List<Integer> testEmptyList = new ArrayList<>();

        //When
        oddNumbersExterminatorForEmptyList.exterminate(testEmptyList);
        List<Integer> expectedEmptyList = new ArrayList<>();
        //Then
        Assertions.assertEquals(expectedEmptyList, testEmptyList);
    }

    @DisplayName("Odd numbers exterminator test for list of integers")

    @Test
    void testOddNumbersExterminatorList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> testList;

        //When
        testList = Arrays.asList(10, 0, 8, 100, 1024, 1, 99);
        List<Integer> actualList = oddNumbersExterminator.exterminate(testList);
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(10, 0, 8, 100, 1024));

        //Then
        Assertions.assertEquals(expectedList, actualList);
    }
}
