package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPING = "ShoppingTask";
    public static final String PAINTING = "PaintingTask";
    public static final String DRIVING = "DrivingTask";

    public final Task taskMaker(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("ShoppingTask", "Vegetables",3.5 );
            case PAINTING -> new PaintingTask("PaintingTask", "White", "Walls");
            case DRIVING -> new DrivingTask("DrivingTask", "Home", "byCar");
            default -> null;
        };
    }
}
