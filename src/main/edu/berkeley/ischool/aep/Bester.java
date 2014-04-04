package edu.berkeley.ischool.aep;

/**
 * Created by prabha on 3/7/14.
 */

public class Bester{
    private final Bestable[] thingsToCompare;

    public Bester(Bestable... thingsToCompare){
        if (thingsToCompare == null) throw new NullPointerException();
        this.thingsToCompare = thingsToCompare;
    }

    public Bestable best(){
        Bestable champion = thingsToCompare[0];
        for (int i =1; i<thingsToCompare.length; i++){
            Bestable challenger = thingsToCompare[i];
            if (challenger.betterThan(champion)){
                champion = challenger;
            }
        }

        return champion;
    }
}

