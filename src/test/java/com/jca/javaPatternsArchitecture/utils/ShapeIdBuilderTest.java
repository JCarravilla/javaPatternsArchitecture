package com.jca.javaPatternsArchitecture.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ShapeIdBuilderTest {
    @Test
    public void getShapeIdeTest(){
        ShapeIdBuilder firstInstance = ShapeIdBuilder.getInstance();
        ShapeIdBuilder secondInstance = ShapeIdBuilder.getInstance();

        long id1 = firstInstance.getShapeId();
        long id2 = secondInstance.getShapeId();

        assertNotEquals(id1, id2);
        assertTrue(id1 + 1 == id2);
    }
}
