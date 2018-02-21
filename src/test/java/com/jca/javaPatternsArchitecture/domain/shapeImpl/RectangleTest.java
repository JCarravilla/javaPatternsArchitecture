package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RectangleTest {
    @Test(expected = ShapeCreationException.class)
    public void createARectangleBadArgsTest() throws ShapeCreationException {
        Double[] vals = {new Double(3.4)};
        new Rectangle(vals);
    }

    @Test(expected = ShapeCreationException.class)
    public void createARectangleBadValueTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0), new Double(-2.0)};
        new Rectangle(vals);
    }

    @Test
    public void createARectangleTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0), new Double(2.0)};
        Rectangle rectangle = new Rectangle(vals);
        assertNotNull(rectangle);
    }

    @Test
    public void calculateLazyAreaTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0), new Double(2.0)};
        Rectangle rectangle = new Rectangle(vals);
        assertEquals(new Double(rectangle.getLazyArea()), new Double(6));
    }

    @Test
    public void calculateLazyArea0LengthTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(0.0), new Double(0.0)};
        Rectangle rectangle = new Rectangle(vals);
        assertEquals(rectangle.getLazyArea(), new Double(0));
    }

    @Test
    public void isAPointInRectangleTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(2.0)};
        Rectangle rectangle = new Rectangle(vals);
        assertTrue(rectangle.containsXY(new Point(new Double(1), new Double(1))));
    }

    @Test
    public void isNotAPointInRectangleTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(2.0)};
        Rectangle rectangle = new Rectangle(vals);
        assertFalse(rectangle.containsXY(new Point(new Double(0), new Double(4))));
    }

    @Test
    public void isAPointInPerimeterTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(2.0)};
        Rectangle rectangle = new Rectangle(vals);
        assertTrue(rectangle.containsXY(new Point(new Double(0), new Double(0))));
    }
}
