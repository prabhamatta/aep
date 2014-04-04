package edu.berkeley.ischool.aep;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ignacio on 2/7/14.
 */

public class Rectangle1Test {

    @Test
    public void shouldBeAbleToCreateSquare(){
        assertEquals(25.0, (new Rectangle1(5, 5)).Area());
    }

}
