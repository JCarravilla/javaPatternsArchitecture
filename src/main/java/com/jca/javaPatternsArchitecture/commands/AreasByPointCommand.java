package com.jca.javaPatternsArchitecture.commands;

import com.jca.javaPatternsArchitecture.domain.Point;
import com.jca.javaPatternsArchitecture.domain.ShapeHandler;
import com.jca.javaPatternsArchitecture.utils.OperationException;
import com.jca.javaPatternsArchitecture.utils.ParseUtils;

public class AreasByPointCommand implements Command{
    private Point point;

    public AreasByPointCommand(String[] args) throws OperationException{
        try {
            this.point = ParseUtils.parseStringArrToPoint(java.util.Arrays.copyOfRange(args, 1, args.length));
        }catch (IllegalArgumentException ex){
            throw new OperationException(String.format("Error: can't perform the operation with these params: %s",
                    ParseUtils.parseStringArrToString(args)));
        }
    }

    @Override
    public void execute() {
        ShapeHandler.getInstance().getShapesByPoint(point);
    }
}
