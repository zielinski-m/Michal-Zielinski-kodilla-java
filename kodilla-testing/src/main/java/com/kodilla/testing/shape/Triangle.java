package com.kodilla.testing.shape;

public class Triangle implements Shape {
    @Override
    public String getShapeName() {
        return shapeName;
    }
    public String getField() {
        return field;
    }
    public String shapeName;
    public String field;

    public Triangle(String shapeName, String field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!shapeName.equals(triangle.shapeName)) return false;
        return field.equals(triangle.field);
    }

    @Override
    public int hashCode() {
        int result = shapeName.hashCode();
        result = 31 * result + field.hashCode();
        return result;
    }
}
