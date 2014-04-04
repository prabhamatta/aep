package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by prabha on 3/7/14.
 */
public class ReverseTest {


    @Test
    //testing end condition
    public void reverseSingleChar(){
        String name = "a";
        assertEquals("a",Reverser.reverse(name));
    }

    @Test
    public void isReversed(){
        String name = "HelloWorld";
        assertEquals("dlroWolleH", Reverser.reverse(name));
    }
}
