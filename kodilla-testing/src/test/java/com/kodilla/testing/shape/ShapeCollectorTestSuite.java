package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import java.util.*;

public class ShapeCollectorTestSuite {


    @BeforeEach
    void beforeEach() {
        System.out.println("Test start: ");
    }
    @AfterEach
    void afterEach() {
        System.out.println("Test ended");
    }

    @DisplayName("Shape Collector Test Suite")
    @Nested
    public class AddingAndRemoveFigures {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Circle("circle", "200m2"));
            System.out.println(shapeCollector.getFigure(0).getShapeName());

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeQuantity());
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("Circle", "200m2");
            shapeCollector.addFigure(circle);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeQuantity());
        }
    }

    @Nested
    public class GetAndShowFigures {
    @Test
    void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle("triangle", "100m2");
        shapeCollector.addFigure(triangle);

        //When
        Shape receivedFigure;
        receivedFigure = shapeCollector.getFigure(0);

        //Then
        Assertions.assertEquals(triangle, receivedFigure);

    }

    @Test
    void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        List<Shape> collection = shapeCollector.shapeCollection;

        collection.add(new Circle("circle ", "150m2"));
        collection.add(new Triangle("triangle ", "3m2"));
        collection.add(new Square("square ", "103m2"));

        //When
        String result = shapeCollector.showFigures(collection);
        String expectedResult = "";
        for (Shape collectionShape : collection) {
            expectedResult += collectionShape.getShapeName();
        }

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
    }
}


