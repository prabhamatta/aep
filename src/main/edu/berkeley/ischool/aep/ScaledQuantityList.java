package edu.berkeley.ischool.aep;

/**
 understands list of ScaledQuantities
 */

import java.util.*;

public class ScaledQuantityList {

    public ArrayList<ArithmeticQuantity> ScaledQuantityList  = new  ArrayList<ArithmeticQuantity>();

    public void add(ArithmeticQuantity qty){
        ScaledQuantityList.add(qty);
    }


    public int size() {
        return ScaledQuantityList.size();
    }


    public ScaledQuantity get(int i) {

        return  ScaledQuantityList.get(i);
    }


    public ArithmeticQuantity bestOfList() {

        ArrayList<Double> otherValues = new ArrayList<Double>();

        for (int i = 1; i < ScaledQuantityList.size(); i++) {
            otherValues.add(ScaledQuantityList.get(i).unit.convertTo(ScaledQuantityList.get(i).value, ScaledQuantityList.get(0).unit)) ;
        }
        double bestValue = ScaledQuantityList.get(0).value;
        int bestIndex = 0;   // use this if you want to send exact ArithmeticQuantity

        for (int i = 0; i < otherValues.size(); i++) {
            if (otherValues.get(i) > bestValue){
                bestValue = otherValues.get(i);
                bestIndex = i+1; // use this if you want to send exact ArithmeticQuantity
            }
        }
        // use this if you want to send exact ArithmeticQuantity
        return ScaledQuantityList.get(bestIndex);

////        use this if you want to send base unit ArithmeticQuantity
//        ArithmeticQuantity returnQty =  new ArithmeticQuantity(ScaledQuantityList.get(0).unit ,bestValue) ;
//        return returnQty;

    }


}