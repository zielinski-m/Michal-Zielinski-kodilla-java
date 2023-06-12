package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {

        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        List <String> toDoList = board.getToDoList().getTasks();
        List <String> inProgress = board.getInProgressList().getTasks();
        List <String> doneList = board.getDoneList().getTasks();

        //When
        toDoList.add("Task to do");
        inProgress.add("Task in progress");
        doneList.add("Task done");

        //Then
        assertEquals("Task to do", toDoList.get(0));
        assertEquals("Task in progress", inProgress.get(0));
        assertEquals("Task done", doneList.get(0));

        System.out.println("\n " + ">>>>>>>>> ADDED TASKS <<<<<<<<" + "\n" +
                toDoList.get(0).toString() + "\n" +
                inProgress.get(0).toString() + "\n" +
                doneList.get(0).toString());
    }
}
