package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.domain.Shape;
import com.jca.javaPatternsArchitecture.utils.MathsUtils;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

public class Triangle extends Shape {
    private static final int SHAPE_ARGS = 6;
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;

    public Triangle(Double[] args) throws ShapeCreationException{
        super();

        if (args.length != SHAPE_ARGS) {
            throw new ShapeCreationException(String.format("Error: %d is not a correct number of arguments for a rectangle. " +
                    " Please, provide its X and Y vertices coordinates", args.length));
        } else {
            addShapeId();
            this.vertexA = new Point(args[0], args[1]);
            this.vertexB = new Point(args[2], args[3]);
            this.vertexC = new Point(args[4], args[5]);
        }
    }

    @Override
    public void printMessageNewShape() {
        printShapeInformation(String.format("triangle with vertices at (%f, %f), (%f, %f), (%f, %f).", vertexA.getX(),
                vertexA.getY(), vertexB.getX(), vertexB.getY(), vertexC.getX(), vertexC.getY()));
    }

    /**
     * Calculate through the analysis of the point sign about the half-plane defined by each pair of vertices
     * @param point
     * @return
     */
    @Override
    public boolean containsXY(Point point) {
        boolean b1 = getSign(point, vertexA, vertexB) < 0.0d;
        boolean b2 = getSign(point, vertexB, vertexC) < 0.0d;
        boolean b3 = getSign(point, vertexC, vertexA) < 0.0d;

        return ((b1 == b2) && (b2 == b3));
    }

    private Double getSign(Point point, Point v1, Point v2){
        return (point.getX() - v2.getX()) * (v1.getY() - v2.getY()) - (v1.getX() - v2.getX()) * (point.getY() - v2.getY());
    }

    /**
     * Calculated through Heron (side length method)
     * @return
     */
    @Override
    protected Double getLazyArea() {
        Double lengthA = MathsUtils.getPythagoreanDistance(vertexA, vertexB);
        Double lengthB = MathsUtils.getPythagoreanDistance(vertexA, vertexC);
        Double lengthC = MathsUtils.getPythagoreanDistance(vertexC, vertexB);

        Double semiperimeter = (lengthA + lengthB + lengthC) / 2;

        return Math.sqrt(semiperimeter * (semiperimeter - lengthA) * (semiperimeter - lengthB) * (semiperimeter - lengthC));
    }
}
