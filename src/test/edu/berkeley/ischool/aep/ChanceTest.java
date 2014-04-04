package edu.berkeley.ischool.aep;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class ChanceTest{
//    @Test
//    public void shouldReturnChanceNotHappendingGivenChancePoint4(){
//        Chance c = new Chance(.4);
//        assertEquals(.6, c.getNotChance());
//    }

//    @Test
//    public void shouldReturnChanceNotHappendingGivenChancePoint4(){
//        assertEquals(new Chance(0.4), new Chance(0.4).not());
//    }


    @Test
    public void oneChanceShouldNotBeEqualtoAnother(){
        Chance coinToss = new Chance(.4);
        assertEquals(coinToss,coinToss);
        Chance dieThrow = new Chance(1/6);
        assertFalse(dieThrow.equals(coinToss));
        assertEquals(new Chance(0.4), coinToss);
        assertEquals(new Chance(1-1/6), dieThrow.not());

    }


    @Test
    public void equalsShouldWorkAccordingToContract(){

        Chance coinToss = new Chance(0.4);
        assertFalse(coinToss.equals(null));
        assertFalse(coinToss.equals(new Object()));

        Map map = new HashMap();
        map.put(new Chance(0.4), "Coin Toss");
        assertEquals("Coin Toss", map.get(new Chance(0.4)));

    }

    @Test
    public void chance1AndChance2MustbeProb2MultipliedbyProb1(){
        Chance coinToss = new Chance(0.4);
        Chance dieThrow = new Chance(1/6);
        assertEquals(coinToss.AndProb(dieThrow),dieThrow.AndProb(coinToss));

    }

    @Test
    public void chance1OrChance2MustbeProb2PlusProb1(){
        Chance coinToss = new Chance(0.4);
        Chance dieThrow = new Chance(1/6);
        assertEquals(coinToss.OrProb(dieThrow),dieThrow.OrProb(coinToss));

    }


//    @Test
//    public void subtractionShouldWOrk(){
//      assertEquals(0.2, 1-0.8);   //fails ---> 0.2 cant be represented in binary. Therefore, use Bigdecimal
//      assertEquals(0.25, 1-0.75); //this passes
//
//    }

    @Test
    public void notTest(){
        Chance coinToss = new Chance(0.4);
        assertEquals(new Chance(0.6),coinToss.notProb());
    }

    @Test
    public void TwoFeetIsBestOfTwoFeetOneFeet6Inches1(){

        Chance[] QtyList = new Chance[]{
                new Chance(0.4),
                new Chance(0.5),
                new Chance(0.6),
                new Chance(0.7)
        }      ;

        assertEquals(new Chance(0.7), new Bester(QtyList).best());

    }


}
