package com.jca.javaPatternsArchitecture.utils;

import com.jca.javaPatternsArchitecture.domain.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ParseUtilsTest {
    @Test
    public void parseStringArrToDoubleArrTest(){
        String[] args = {"1", "1.2", "-1"};
        Double[] arrDouble = ParseUtils.parseStringArrToDoubleArr(args);
        assertEquals(arrDouble.length, 3);
        assertEquals(arrDouble[0], new Double(1));
        assertEquals(arrDouble[1], new Double(1.2));
        assertEquals(arrDouble[2], new Double(-1));
    }

    @Test(expected = NumberFormatException.class)
    public void parseStringArrToDoubleArrFailTest(){
        String[] args = {"1", "1.2", "a"};
        ParseUtils.parseStringArrToDoubleArr(args);
    }

    @Test
    public void parseStringArrToPointTest(){
        String[] args = {"1", "1.2"};
        Point point = ParseUtils.parseStringArrToPoint(args);
        assertEquals(point.getX(), new Double(1));
        assertEquals(point.getY(), new Double(1.2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringArrToPointFailMoreArgsTest(){
        String[] args = {"1", "1.2", "-1"};
        ParseUtils.parseStringArrToPoint(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringArrToPointFailLessArgsTest(){
        String[] args = {"1"};
        ParseUtils.parseStringArrToPoint(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringArrToPointFailBadArgsTest(){
        String[] args = {"1", "a"};
        ParseUtils.parseStringArrToPoint(args);
    }

    @Test
    public void parseStringArrToStringdefSepTest(){
        String[] args = {"circle", "1", "2.2", "f"};
        assertEquals(ParseUtils.parseStringArrToString(args), "circle 1 2.2 f");
    }

    @Test
    public void parseStringArrToStringTest(){
        String[] args = {"circle", "1", "2.2", "f"};
        assertEquals(ParseUtils.parseStringArrToString(args, '-'), "circle-1-2.2-f");
    }
}
