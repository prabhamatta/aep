package edu.berkeley.ischool.aep;

/**
 ScaledQuantity --> parent class
 ArithmeticQuantity extends ScaledQuantity
 */
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(Unit unit, double value){
        super(unit,value);
    }

    public ArithmeticQuantity add(ArithmeticQuantity otherQuantity) {

        double otherValue = otherQuantity.unit.convertTo(otherQuantity.value, this.unit);
        return new ArithmeticQuantity(this.unit, this.value + otherValue);

    }
}
