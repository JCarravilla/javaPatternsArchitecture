package com.jca.javaPatternsArchitecture.domain;

import com.jca.javaPatternsArchitecture.domain.shapeImpl.*;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

public class ShapeFactory {

    public static Shape getNewShape(String shape, Double[] args) throws ShapeCreationException{
        if(shape.equals("circle")){
            return new Circle(args);
        } else if (shape.equals("square")) {
            return new Square(args);
        } else if (shape.equals("rectangle")) {
            return new Rectangle(args);
        } else if (shape.equals("triangle")) {
            return new Triangle(args);
        } else if (shape.equals("donut")) {
            return new Donut(args);
        } else {
            throw new ShapeCreationException(String.format("Build error: %s is not a valid shape name.", shape));
        }
    }
}
