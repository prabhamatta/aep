package edu.berkeley.ischool.aep;

/**
 * Created by prabha on 3/7/14.
 */
public class Reverser {

    public static String reverse(String myString){
        if(myString.length() == 1){
            return myString;
        }
        return reverse(myString.substring(1)) + myString.charAt(0);


    }
}
