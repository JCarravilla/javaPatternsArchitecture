package com.jca.javaPatternsArchitecture.domain;

import com.jca.javaPatternsArchitecture.utils.ShapeIdBuilder;
import lombok.Data;

@Data
public abstract class Shape {
    private Long shapeId;
    private Double area;

    protected void addShapeId(){
        shapeId = ShapeIdBuilder.getInstance().getShapeId();
    }

    abstract public void printMessageNewShape();

    abstract public boolean containsXY(Point point);

    abstract protected Double getLazyArea();

    public Double getArea(){
        if(area == null){
            area = getLazyArea();
        }
        return area;
    }

    protected void printShapeInformation(String msg){
        System.out.println(String.format("=> Shape %d: %s", shapeId, msg));
    }

    protected String getShapeInfo(){
        return String.format("Shape %d", shapeId);
    }

}
