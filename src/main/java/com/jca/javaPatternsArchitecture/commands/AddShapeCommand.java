package com.jca.javaPatternsArchitecture.commands;

import com.jca.javaPatternsArchitecture.domain.ShapeHandler;
import com.jca.javaPatternsArchitecture.utils.ParseUtils;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;

public class AddShapeCommand implements Command{
    private String shapeName;
    private Double[] shapeParams;

    public AddShapeCommand(String[] args) throws ShapeCreationException{
        try{
            this.shapeName = args[0];
            this.shapeParams = ParseUtils.parseStringArrToDoubleArr(java.util.Arrays.copyOfRange(args, 1, args.length));
        } catch(NumberFormatException e){
            throw new ShapeCreationException(String.format("Error: can't perform the operation with these params: %s",
                    ParseUtils.parseStringArrToString(args)));
        }
    }

    @Override
    public void execute() {
        ShapeHandler.getInstance().addShape(shapeName, shapeParams);
    }
}
