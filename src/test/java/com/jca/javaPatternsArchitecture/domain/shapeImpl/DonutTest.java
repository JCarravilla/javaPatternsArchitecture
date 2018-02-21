package com.jca.javaPatternsArchitecture.domain.shapeImpl;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class DonutTest {
    @Test(expected = ShapeCreationException.class)
    public void createADonutBadArgsTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4)};
        new Donut(vals);
    }

    @Test(expected = ShapeCreationException.class)
    public void createADonutBadValueTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0), new Double(-2.0)};
        new Donut(vals);
    }

    @Test
    public void createADonutTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0), new Double(2.0)};
        Donut donut = new Donut(vals);
        assertNotNull(donut);
    }

    @Test
    public void calculateLazyAreaTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(3.0), new Double(1.0)};
        Donut donut = new Donut(vals);
        assertEquals(new Double(Math.round(donut.getLazyArea() * 10000)/10000d), new Double(25.1327));
    }

    @Test
    public void calculateLazyArea0RadiusTest() throws ShapeCreationException{
        Double[] vals = {new Double(3.4), new Double(3.4), new Double(0.0), new Double(0.0)};
        Donut donut = new Donut(vals);
        assertEquals(donut.getLazyArea(), new Double(0));
    }

    @Test
    public void isAPointInDonutTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(1.0)};
        Donut donut = new Donut(vals);
        assertTrue(donut.containsXY(new Point(new Double(0), new Double(2))));
    }

    @Test
    public void isNotAPointInDonutInnerTest() throws ShapeCreationException {
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(1.0)};
        Donut donut = new Donut(vals);
        assertFalse(donut.containsXY(new Point(new Double(0), new Double(0.5))));
    }

    @Test
    public void isNotAPointInDonutOuterTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(1.0)};
        Donut donut = new Donut(vals);
        assertFalse(donut.containsXY(new Point(new Double(0), new Double(4))));
    }

    @Test
    public void isAPointInOuterPerimeterTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(1.0)};
        Donut donut = new Donut(vals);
        assertTrue(donut.containsXY(new Point(new Double(0), new Double(3))));
    }

    @Test
    public void isAPointInInnerPerimeterTest() throws ShapeCreationException{
        Double[] vals = {new Double(0.0), new Double(0.0), new Double(3.0), new Double(1.0)};
        Donut donut = new Donut(vals);
        assertTrue(donut.containsXY(new Point(new Double(0), new Double(1))));
    }
}
