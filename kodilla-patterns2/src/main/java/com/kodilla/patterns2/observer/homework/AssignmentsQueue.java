package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsQueue implements Observable {

    private final List<Observer> observers;
    private final List<String> assignments;
    private final String name;

    public AssignmentsQueue(String name) {
        observers = new ArrayList<>();
        assignments = new ArrayList<>();
        this.name = name;
    }

    public void addAssignment(String assignment) {
        assignments.add(assignment);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public String getName() {
        return name;
    }
}
