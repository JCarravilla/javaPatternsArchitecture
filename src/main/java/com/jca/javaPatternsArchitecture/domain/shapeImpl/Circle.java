package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.domain.Shape;
import com.jca.javaPatternsArchitecture.utils.MathsUtils;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

public class Circle extends Shape{
    private static final int SHAPE_ARGS = 3;
    private Point center;
    private double radius;

    public Circle(Double[] args) throws ShapeCreationException{
        super();

        if (args.length != SHAPE_ARGS) {
            throw new ShapeCreationException(String.format("Error: %d is not a correct number of arguments for a circle. " +
                    " Please, provide X and Y center coordinates and a positive radius", args.length));
        } else if(args[2] < 0) {
            throw new ShapeCreationException("Error:  Bad formed arguments for a circle.  Radius must be greater than 0");
        } else {
            addShapeId();
            this.center = new Point(args[0], args[1]);
            this.radius = args[2];
        }
    }

    @Override
    public void printMessageNewShape() {
        printShapeInformation(String.format("circle with centre at (%f, %f) and radius %f.",
                center.getX(), center.getY(), radius));
    }

    /**
     * Calculates if a point is inside the circle through the Pythagorean theorem
     */
    @Override
    public boolean containsXY(Point point) {
        return this.radius >= MathsUtils.getPythagoreanDistance(point, center);
    }

    @Override
    protected Double getLazyArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }


}
