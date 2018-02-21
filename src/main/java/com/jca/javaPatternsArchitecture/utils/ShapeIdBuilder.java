package com.jca.javaPatternsArchitecture.utils;

public class ShapeIdBuilder {
    private static ShapeIdBuilder instance = null;
    private static long currentId = 0l;

    private ShapeIdBuilder(){
        instance = this;
    }

    public static ShapeIdBuilder getInstance(){
        if (instance == null){
            new ShapeIdBuilder();
        }

        return instance;
    }

    public long getShapeId(){
        return ++currentId;
    }
}
