package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CircleTest {
    @Test(expected = ShapeCreationException.class)
    public void createACircleBadArgsTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4)};
        new Circle(vals);
    }

    @Test(expected = ShapeCreationException.class)
    public void createACircleBadValueTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(-2.0)};
        new Circle(vals);
    }

    @Test
    public void createACircleTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0)};
        Circle circle = new Circle(vals);
        assertNotNull(circle);
    }

    @Test
    public void calculateLazyAreaTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0)};
        Circle circle = new Circle(vals);
        assertEquals(new Double(Math.round(circle.getLazyArea() * 10000)/10000d), new Double(28.2743));
    }

    @Test
    public void calculateLazyArea0RadiusTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(0.0)};
        Circle circle = new Circle(vals);
        assertEquals(circle.getLazyArea(), new Double(0));
    }

    @Test
    public void isAPointInCircleTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0)};
        Circle circle = new Circle(vals);
        assertTrue(circle.containsXY(new Point(new Double(0), new Double(2))));
    }

    @Test
    public void isNotAPointInCircleTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0)};
        Circle circle = new Circle(vals);
        assertFalse(circle.containsXY(new Point(new Double(0), new Double(4))));
    }

    @Test
    public void isAPointInPerimeterTest() throws ShapeCreationException {
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0)};
        Circle circle = new Circle(vals);
        assertTrue(circle.containsXY(new Point(new Double(0), new Double(3))));
    }

}
