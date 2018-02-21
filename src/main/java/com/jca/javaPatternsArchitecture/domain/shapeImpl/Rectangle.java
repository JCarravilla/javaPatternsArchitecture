package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.domain.Shape;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

public class Rectangle extends Shape {
    private static final int SHAPE_ARGS = 4;
    private Point corner;
    private double lengthLong;
    private double lengthShort;

    /**
     * Lets suppose the provided corner is the left - lower one and that the rectangle lays over its longer side
     * @param args
     * @throws Exception
     */
    public Rectangle(Double[] args) throws ShapeCreationException{
        super();

        if (args.length != SHAPE_ARGS) {
            throw new ShapeCreationException(String.format("Error: %d is not a correct number of arguments for a rectangle. " +
                    " Please, provide a X and Y corner coordinates and the length of both sides", args.length));
        } else if(args[2] < 0 || args[3] < 0) {
            throw new ShapeCreationException("Error:  Bad formed arguments for a rectangle. Both side length must be greater than 0");
        } else {
            addShapeId();
            this.corner = new Point(args[0], args[1]);
            if(args[2] > args[3]) {
                this.lengthLong = args[2];
                this.lengthShort = args[3];
            } else {

                this.lengthLong = args[3];
                this.lengthShort = args[2];
            }
        }
    }

    @Override
    public void printMessageNewShape() {
        printShapeInformation(String.format("rectangle with corner at (%f, %f) and side lengths %f and %f.",
                corner.getX(), corner.getY(), lengthLong, lengthShort));
    }

    @Override
    public boolean containsXY(Point point) {
        return point.getX() >= corner.getX() && point.getX() <= corner.getX() + lengthLong &&
                point.getY() >= corner.getY() && point.getY() <= corner.getY() + lengthShort;
    }

    @Override
    protected Double getLazyArea() {
        return lengthLong * lengthShort;
    }
}
