package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.domain.Shape;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

public class Square extends Shape {
    private static final int SHAPE_ARGS = 3;
    private Point corner;
    private double length;

    /**
     * Lets suppose the provided corner is the left - lower one
     * @param args
     * @throws Exception
     */
    public Square(Double[] args) throws ShapeCreationException{
        super();

        if (args.length != SHAPE_ARGS) {
            throw new ShapeCreationException(String.format("Error: %d is not a correct number of arguments for a square. " +
                    " Please, provide a X and Y corner coordinates and the length of its sides", args.length));
        } else if(args[2] < 0) {
            throw new ShapeCreationException("Error:  Bad formed arguments for a square.  Side length must be greater than 0");
        } else {
            addShapeId();
            this.corner = new Point(args[0], args[1]);
            this.length = args[2];
        }
    }

    @Override
    public void printMessageNewShape() {
        printShapeInformation(String.format("square with corner at (%f, %f) and side length %f.",
                corner.getX(), corner.getY(), length));
    }

    @Override
    public boolean containsXY(Point point) {
        return point.getX() >= corner.getX() && point.getX() <= corner.getX() + length &&
                point.getY() >= corner.getY() && point.getY() <= corner.getY() + length;
    }

    @Override
    protected Double getLazyArea() {
        return Math.pow(length, 2);
    }
}
