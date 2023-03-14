package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {

    public List<Shape> shapeCollection = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapeCollection.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapeCollection.contains(shape)) {
            shapeCollection.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int figureNumber) {
        if (figureNumber >= 0 && figureNumber < shapeCollection.size()) {
            return shapeCollection.get(figureNumber);
        }
        return null;
    }

    public String showFigures(List<Shape> collection) {

        List<String> showFiguresList = new ArrayList<>();
        Shape shapeOfCollection;

        for (int i = 0; i < collection.size(); i++) {
            shapeOfCollection = collection.get(i);
            String nameOfShape = shapeOfCollection.getShapeName();
            showFiguresList.add(nameOfShape);
        }
        String listAsString = String.join("", showFiguresList);
        return listAsString;
    }

    public int getShapeQuantity() {
        return shapeCollection.size();
    }
}
