package com.jca.javaPatternsArchitecture.utils;

import com.jca.javaPatternsArchitecture.domain.Point;

public class MathsUtils {
    public static Double getPythagoreanDistance(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
    }

}
