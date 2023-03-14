package com.kodilla.testing.shape;

public class Square implements Shape {
    @Override
    public String getShapeName() {
        return shapeName;
    }
    @Override
    public String getField() {
        return field;
    }
    private String shapeName;
    private String field;

    public Square(String shapeName, String field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (!shapeName.equals(square.shapeName)) return false;
        return field.equals(square.field);
    }

    @Override
    public int hashCode() {
        int result = shapeName.hashCode();
        result = 31 * result + field.hashCode();
        return result;
    }
}
