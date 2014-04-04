package edu.berkeley.ischool.aep;

/**
 *understands the unit and value for a measurement
 */

public class ScaledQuantity implements Bestable<ScaledQuantity>{                 // before parameterizing : public class ScaledQuantity implements Bestable

    final Unit unit;
    final double value;


    public ScaledQuantity(Unit unit, double value){
        this.unit = unit;
        this.value = value;
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQuantity =  (ScaledQuantity) other;
        double otherValue = otherQuantity.unit.convertTo(otherQuantity.value, this.unit);
        return this.value == otherValue;

    }

    @Override
    public int hashCode(){
        long longBits = Double.doubleToLongBits(value);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public boolean betterThan(ScaledQuantity other) {
        ScaledQuantity otherQuantity = (ScaledQuantity) other;

        double otherValue = otherQuantity.unit.convertTo(otherQuantity.value, this.unit);
         if (this.value > otherValue){
             return true;
         }
         else {
             return false;
         }

    }

//    public boolean bestOf(ScaledQuantityList SQList) {    // ScaledQuantity... args
//
//        if (SQList.size() == 1) {
//            double otherValue = SQList.get(0).unit.convertTo(SQList.get(0).value, this.unit);
//            if (this.value > otherValue){
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        else{
//
//            ArrayList<Double> otherValues = new ArrayList<Double>();
//
//            for (int i = 1; i < SQList.size(); i++) {
////                otherValues.add(SQList.get(i).unit.convertTo(SQList.get(i).value, SQList.get(0).unit)) ;
//                otherValues.add(1.3) ;
//            }
//            double otherValue;
//            Collections.sort(otherValues);
//            otherValue = otherValues.get(0);
//            if (this.value > otherValue){
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//
//    }



}
