package com.jca.javaPatternsArchitecture.utils;

import com.jca.javaPatternsArchitecture.domain.Point;

public class ParseUtils {
    public static Double[] parseStringArrToDoubleArr(String[] a) throws NumberFormatException{
        Double[] parsed = new Double[a.length];
        for(int i = 0; i< a.length; i++){
            parsed[i] = Double.parseDouble(a[i]);
        }
        return parsed;
    }

    public static Point parseStringArrToPoint(String[] a) throws IllegalArgumentException{
        if(a.length == 2){
            Double[] asDouble = parseStringArrToDoubleArr(a);
            return new Point(asDouble[0], asDouble[1]);
        } else {
            throw new IllegalArgumentException("Incorrect number of args");
        }
    }

    public static String parseStringArrToString(String[] a, char separator){
        String ret = "";
        for (String val: a){
            ret += val += separator;
        }
        return ret.substring(0, ret.length() - 1);
    }

    public static String parseStringArrToString(String[] a){
        return parseStringArrToString(a, ' ');
    }
}
