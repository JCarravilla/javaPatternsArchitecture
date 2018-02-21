package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.domain.Shape;
import com.jca.javaPatternsArchitecture.utils.MathsUtils;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

public class Donut extends Shape {
    private static final int SHAPE_ARGS = 4;
    private Point center;
    private double radiusMax;
    private double radiusMin;

    public Donut(Double[] args) throws ShapeCreationException{
        super();

        if (args.length != SHAPE_ARGS) {
            throw new ShapeCreationException(String.format("Error: %d is not a correct number of arguments for a donut. " +
                    " Please, provide X and Y center coordinates and two positive radius", args.length));
        } else if(args[2] < 0 || args[3] < 0) {
            throw new ShapeCreationException("Error:  Bad formed arguments for a donut.  Both radius must be greater than 0");
        } else {
            addShapeId();
            this.center = new Point(args[0], args[1]);
            if(args[2] > args[3]) {
                this.radiusMax = args[2];
                this.radiusMin = args[3];
            }else{
                this.radiusMax = args[3];
                this.radiusMin = args[2];
            }
        }
    }

    @Override
    public void printMessageNewShape() {
        printShapeInformation(String.format("donut with centre at (%f, %f) and radius %f and %f.", center.getX(),
                center.getY(), radiusMax, radiusMin));
    }

    @Override
    public boolean containsXY(Point point) {
        Double distance = MathsUtils.getPythagoreanDistance(point, center);
        return this.radiusMax >= distance && this.radiusMin <= distance;
    }

    @Override
    protected Double getLazyArea() {
        return Math.PI * (Math.pow(this.radiusMax, 2) - Math.pow(this.radiusMin, 2));
    }
}
