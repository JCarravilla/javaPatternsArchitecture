package com.jca.javaPatternsArchitecture.domain;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ShapeHandlerTest {

    @BeforeClass
    public static  void initialize() {

        Double[] circleArr= {new Double(0), new Double(0), new Double(3)};
        Double[] donutArr= {new Double(0), new Double(0), new Double(3), new Double(1)};
        Double[] squareArr= {new Double(-1), new Double(-1), new Double(2)};
        Double[] rectangleArr= {new Double(-5), new Double(-5), new Double(3), new Double(2)};
        Double[] triangleArr= {new Double(0), new Double(0), new Double(4), new Double(0),
                new Double(2), new Double(2)};

        ShapeHandler.getInstance().addShape("circle", circleArr);
        ShapeHandler.getInstance().addShape("donut", donutArr);
        ShapeHandler.getInstance().addShape("square", squareArr);
        ShapeHandler.getInstance().addShape("rectangle", rectangleArr);
        ShapeHandler.getInstance().addShape("triangle", triangleArr);
    }

    @Test
    public void getShapeAreasByPointTest(){
        Double area = ShapeHandler.getInstance().getShapeAreasByPoint(new Point(new Double(0.1), new Double(0.1)));
        assertEquals(new Double(Math.round(area * 10000)/10000d), new Double(36.2743));
    }

    @Test
    public void getShapeAreasByPoint0CoincidencesTest(){
        Double area = ShapeHandler.getInstance().getShapeAreasByPoint(new Point(new Double(100), new Double(100)));
        assertEquals(area, new Double(0));
    }
}
