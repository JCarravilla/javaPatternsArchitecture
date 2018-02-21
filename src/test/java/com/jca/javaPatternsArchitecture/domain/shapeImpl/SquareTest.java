package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SquareTest {
    @Test(expected = ShapeCreationException.class)
    public void createASquareBadArgsTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4)};
        new Square(vals);
    }

    @Test(expected = ShapeCreationException.class)
    public void createASquareBadValueTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(-3.0)};
        new Square(vals);
    }

    @Test
    public void createASquareTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0)};
        Square square = new Square(vals);
        assertNotNull(square);
    }

    @Test
    public void calculateLazyAreaTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0)};
        Square square = new Square(vals);
        assertEquals(square.getLazyArea(), new Double(9));
    }

    @Test
    public void calculateLazyArea0RadiusTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(0.0)};
        Square square = new Square(vals);
        assertEquals(square.getLazyArea(), new Double(0));
    }

    @Test
    public void isAPointInSquareTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0)};
        Square square = new Square(vals);
        assertTrue(square.containsXY(new Point(new Double(2), new Double(2))));
    }

    @Test
    public void isNotAPointInSquareTest() throws ShapeCreationException {
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0)};
        Square square = new Square(vals);
        assertFalse(square.containsXY(new Point(new Double(2), new Double(4))));
    }

    @Test
    public void isAPointInPerimeterTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0)};
        Square square = new Square(vals);
        assertTrue(square.containsXY(new Point(new Double(0), new Double(3))));
    }
}
