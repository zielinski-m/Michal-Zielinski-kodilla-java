package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(AssignmentsQueue assignmentsQueue) {
        System.out.println(name + ": New assignment in queue " + assignmentsQueue.getName() + "\n" +
                "total: " + assignmentsQueue.getAssignments().size() + " assignments");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
