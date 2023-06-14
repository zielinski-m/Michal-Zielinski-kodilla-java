package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void ShoppingTaskTest() {

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shopping = taskFactory.taskMaker(TaskFactory.SHOPPING);

        //Then
        assertEquals("ShoppingTask", shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());
    }

    @Test
    void PaintingTaskTest() {

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task painting = taskFactory.taskMaker(TaskFactory.PAINTING);
        painting.executeTask();

        //Then
        assertTrue(painting.isTaskExecuted());
        assertEquals("PaintingTask", painting.getTaskName());
    }

    @Test
    void DrivingTaskTest() {

        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task driving = taskFactory.taskMaker(TaskFactory.DRIVING);
        driving.executeTask();

        //Then
        assertEquals("DrivingTask", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
