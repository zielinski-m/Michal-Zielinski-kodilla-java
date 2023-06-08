package com.kodilla.spring.intro;

import com.kodilla.spring.intro.shape.Circle;
import com.kodilla.spring.intro.shape.Drawer;
import com.kodilla.spring.intro.shape.Shape;
import com.kodilla.spring.intro.shape.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle() {
        //Given
        Circle circle = new Circle();

        //When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a circle", result);
    }

    @Test
    void testDoDrawingWithTriangle() {
        //Given
        Triangle triangle = new Triangle();

        //Whem
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a triangle", result);
    }
}
