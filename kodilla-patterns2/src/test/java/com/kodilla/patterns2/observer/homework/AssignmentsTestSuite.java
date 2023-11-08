package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentsTestSuite {

    @Test
    void testAddAssignment() {
        //Given
        AssignmentsQueue assignmentsQueue1 = new AssignmentsQueue("Student 1");
        AssignmentsQueue assignmentsQueue2 = new AssignmentsQueue("Student 2");
        Mentor mentor1 = new Mentor("Mentor1");
        Mentor mentor2 = new Mentor("Mentor2");
        assignmentsQueue1.registerObserver(mentor1);
        assignmentsQueue2.registerObserver(mentor1);
        assignmentsQueue2.registerObserver(mentor2);

        //When
        assignmentsQueue1.addAssignment("Homework 1");
        assignmentsQueue2.addAssignment("Homework 2");
        assignmentsQueue1.addAssignment("Homework 3");
        assignmentsQueue1.addAssignment("Homework 4");
        assignmentsQueue2.addAssignment("Homework 5");
        assignmentsQueue1.addAssignment("Homework 6");

        //Then

        assertEquals(4,assignmentsQueue1.getAssignments().size());
        assertEquals("Student 1", assignmentsQueue1.getName());
        assertEquals(6, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());

    }
}
