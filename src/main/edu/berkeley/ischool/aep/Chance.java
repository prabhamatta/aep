package edu.berkeley.ischool.aep;
/* * gives the probability of an event*/


public class Chance implements Bestable<Chance> {
    private final double chance_prob;
    public Chance(double prob){
        chance_prob = prob;

    }


    public Chance not(){
//        System.out.println(this.chance_prob);
        //immutability - instead of changing the original object, we need to create a new object
        Chance something = new Chance(1-this.chance_prob);
        return something;
    }

    @Override
    public boolean equals(Object other) {
//        return (this.chance_prob ==((Chance)other).chance_prob);
        if (other == this) return true; //default implementation of equals
        if (!(other instanceof Chance)) return false;
        return Math.abs(chance_prob - ((Chance) other).chance_prob) < 0.0000000000000001;

    }

    @Override
    public int hashCode() {
//        return super.hashCode();    //To change body of overridden methods use File | Settings | File Templates.
        long longBits = Double.doubleToLongBits(chance_prob);
        return (int)(longBits^(longBits>>>32));
    }

    public Chance AndProb(Object other){
        return new Chance(chance_prob*((Chance) other).chance_prob);

    }
//    public double LogicalAnd(Chance b){
//        return new Chance(this.chance_prob*b.chance_prob);
//
//    }

    public Chance OrProb(Object other){
        //Morgan's LAw
        Chance B = (Chance) other;

        //return new Chance(chance_prob+((Chance) other).chance_prob);
        return this.notProb().AndProb(B.notProb()).notProb();


    }

    public Chance notProb(){
        return new Chance(1-chance_prob);

    }

    @Override
    public boolean betterThan(Chance other) {
        Chance otherQuantity = (Chance) other;

        if (this.chance_prob > otherQuantity.chance_prob){
            return true;
        }
        else {
            return false;
        }

    }
}