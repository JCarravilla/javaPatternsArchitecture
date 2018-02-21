package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TriangleTest {
    @Test(expected = ShapeCreationException.class)
    public void createATriangleBadArgsTest() throws ShapeCreationException {
        Double[] vals = {new Double(3.4)};
        new Triangle(vals);
    }

    @Test
    public void createATriangleTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0),new Double(3.4),
                new Double(3.4), new Double(3.0)};
        Triangle triangle = new Triangle(vals);
        assertNotNull(triangle);
    }

    @Test
    public void calculateLazyAreaTest() throws ShapeCreationException{
        Double[] vals = {new Double(0), new Double(0), new Double(4), new Double(0),
                new Double(2), new Double(2)};
        Triangle triangle = new Triangle(vals);
        assertEquals(new Double(Math.round(triangle.getLazyArea() * 10000)/10000d), new Double(4));
    }

    @Test
    public void calculateLazyArea0RadiusTest() throws ShapeCreationException{
        Double[] vals = {new Double(0), new Double(0), new Double(0), new Double(0),
                new Double(0), new Double(0)};
        Triangle triangle = new Triangle(vals);
        assertEquals(triangle.getLazyArea(), new Double(0));
    }

    @Test
    public void isAPointInTriangleTest() throws ShapeCreationException{
        Double[] vals = {new Double(0), new Double(0), new Double(4), new Double(0),
                new Double(2), new Double(2)};
        Triangle triangle = new Triangle(vals);
        assertTrue(triangle.containsXY(new Point(new Double(2), new Double(1))));
    }

    @Test
    public void isNotAPointInTriangleTest() throws ShapeCreationException{
        Double[] vals = {new Double(0), new Double(0), new Double(4), new Double(0),
                new Double(2), new Double(2)};
        Triangle triangle = new Triangle(vals);
        assertFalse(triangle.containsXY(new Point(new Double(0), new Double(5))));
    }

    @Test
    public void isAPointInPerimeterTest() throws ShapeCreationException{
        Double[] vals = {new Double(0), new Double(0), new Double(4), new Double(0),
                new Double(2), new Double(2)};
        Triangle triangle = new Triangle(vals);
        assertTrue(triangle.containsXY(new Point(new Double(3), new Double(0))));
    }
    
}
