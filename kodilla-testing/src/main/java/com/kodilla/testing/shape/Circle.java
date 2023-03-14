package com.kodilla.testing.shape;

public class Circle implements Shape {
    @Override
    public String getShapeName() {
        return shapeName;
    }
    @Override
    public String getField() {
        return field;
    }

    public String shapeName;
    public String field;

    public Circle(String shapeName, String field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (!shapeName.equals(circle.shapeName)) return false;
        return field.equals(circle.field);
    }

    @Override
    public int hashCode() {
        int result = shapeName.hashCode();
        result = 31 * result + field.hashCode();
        return result;
    }
}


