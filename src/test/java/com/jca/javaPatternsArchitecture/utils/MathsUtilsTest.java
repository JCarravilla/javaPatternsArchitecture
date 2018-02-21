package com.jca.javaPatternsArchitecture.utils;

import com.jca.javaPatternsArchitecture.domain.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MathsUtilsTest {
    @Test
    public void getPythagoreanDistanceTest(){
        Point pointA = new Point(new Double(0), new Double(0));
        Point pointB = new Point(new Double(1), new Double(5));
        assertEquals(new Double(Math.round(MathsUtils.getPythagoreanDistance(pointA, pointB) * 1000)/1000d), new Double(5.099));
    }
}
