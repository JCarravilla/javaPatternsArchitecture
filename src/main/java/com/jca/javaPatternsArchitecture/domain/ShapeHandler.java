package com.jca.javaPatternsArchitecture.domain;

import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

import java.util.ArrayList;

public class ShapeHandler {
    private static ShapeHandler instance;
    private static ArrayList<Shape> storage;

    private ShapeHandler(){
        storage = new ArrayList<>();
    }

    public static ShapeHandler getInstance(){
        if(instance == null){
            instance = new ShapeHandler();
        }
        return instance;
    }

    public void addShape(String name, Double[] args){
        try {
            Shape shape = ShapeFactory.getNewShape(name, args);
            storage.add(shape);
            shape.printMessageNewShape();
        }catch (ShapeCreationException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getShapesByPoint(Point point){
        System.out.println(String.format("==>Listing all shapes that contains (%f, %f):", point.getX(), point.getY()));
        Double totalArea = getShapeAreasByPoint(point);
        System.out.println(String.format("==>The total area is %f", totalArea));
    }

    protected Double getShapeAreasByPoint(Point point){
        return storage.parallelStream().
               filter(shape -> shape.containsXY(point)).
               map(shape -> {
                   Number[] data = {shape.getShapeId(), shape.getArea()};
                   return data;
               }).
               peek((data) -> System.out.println(String.format("-Shape %d -> Area: %f",data[0], data[1]))).
               map(arr -> (Double)arr[1]).
               reduce(0d, (a,b) -> a + b);
    }
}
