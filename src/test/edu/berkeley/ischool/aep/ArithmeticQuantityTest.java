package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 *tests ArithmeticQuantity and related classes and methods
 */
public class ArithmeticQuantityTest {

    @Test
    public void threeFeetShouldEqualOneYard(){
        assertEquals(new ArithmeticQuantity(Unit.YARDS, 1.0), new ArithmeticQuantity(Unit.FEET, 3));
    }

    @Test
    public void oneMileShouldEqual1760Yard(){
        assertEquals(new ArithmeticQuantity(Unit.MILES, 1.0), new ArithmeticQuantity(Unit.YARDS, 1760));
    }

    @Test
    public void oneCupShouldEqualEightOz(){
        assertEquals(new ArithmeticQuantity(Unit.CUP, 1.0), new ArithmeticQuantity(Unit.OZ, 8));
    }

    @Test
    public void oneTbspShouldEqualThreeTsp(){
        assertEquals(new ArithmeticQuantity(Unit.TBSP, 1.0),new ArithmeticQuantity(Unit.TSP, 3));
    }

    @Test
    public void twoInchesAddtwoInchesEqualsFourInches(){
        assertEquals(new ArithmeticQuantity(Unit.INCHES, 4.0), new ArithmeticQuantity(Unit.INCHES, 2).add(new ArithmeticQuantity(Unit.INCHES, 2)));
    }

    @Test
    public void twoTbspAddOneOzEqualsTwelveTsp(){
        assertEquals(new ArithmeticQuantity(Unit.TSP, 12.0), new ArithmeticQuantity(Unit.TBSP, 2).add(new ArithmeticQuantity(Unit.OZ, 1)));
        assertEquals(new ArithmeticQuantity(Unit.TSP, 12.0),
                new ArithmeticQuantity(Unit.OZ, 1).add(new ArithmeticQuantity(Unit.TBSP, 2)));

    }


    @Test(expected = RuntimeException.class)
    public void oneTspNotEqualOneFeetShouldThrowException() {
        assertEquals(new ArithmeticQuantity(Unit.TSP, 1.0), new ArithmeticQuantity(Unit.FEET, 1)); // this should throw an exception

    }

    @Test(expected = RuntimeException.class)
    public void twoOzPlusOneFootShouldThrowException() {
        assertEquals(new ArithmeticQuantity(Unit.FEET, 2),
                new ArithmeticQuantity(Unit.FEET, 1).add(new ArithmeticQuantity(Unit.OZ, 2)));  // this should throw an exception
    }

    @Test
    public void HundredCEquals120F(){
        assertEquals(new ScaledQuantity(Unit.C, 100.0),new ScaledQuantity(Unit.F, 212));
    }

    @Test
    public void ThirtyTwoFEqualsZeroC(){
        assertEquals(new ScaledQuantity(Unit.C, 0.0),new ScaledQuantity(Unit.F, 32));
    }

   /*
   @Test
    public void minusFortyCPlusMinusFortyFEqualsMinusEightyC(){
        assertEquals(new ScaledQuantity(Unit.C, -80.0), new ScaledQuantity(Unit.F, -40.0).add(new ScaledQuantity(Unit.C, -40.0)));
    }
      */

    @Test
    public void OneFeetBetterThan6Inches(){
        assertEquals(true,  new ArithmeticQuantity(Unit.FEET, 1).betterThan(new ArithmeticQuantity(Unit.INCHES, 6)));
        assertTrue(  new ArithmeticQuantity(Unit.FEET, 1).betterThan(new ArithmeticQuantity(Unit.INCHES, 6)));
    }

    @Test
    public void TwoFeetIsBestOfTwoFeetOneFeet6Inches(){

        ScaledQuantityList QtyList = new ScaledQuantityList();
        QtyList.add(new ArithmeticQuantity(Unit.INCHES, 6) )  ;
        QtyList.add(new ArithmeticQuantity(Unit.FEET, 2) )  ;
        QtyList.add(new ArithmeticQuantity(Unit.FEET, 1) )  ;
        QtyList.add(new ArithmeticQuantity(Unit.INCHES, 8) )  ;
//        QtyList.add(new ArithmeticQuantity(Unit.MILES, 0.5) )  ;

        assertEquals(new ArithmeticQuantity(Unit.INCHES, 24), QtyList.bestOfList());

    }

    @Test
    public void TwoFeetIsBestOfTwoFeetOneFeet6Inches1(){

        ScaledQuantity[] QtyList = new ScaledQuantity[]{
                new ArithmeticQuantity(Unit.INCHES, 6),
                new ArithmeticQuantity(Unit.FEET, 6),
                new ArithmeticQuantity(Unit.FEET, 2),
                new ArithmeticQuantity(Unit.INCHES, 6)
        }      ;

        assertEquals(new ArithmeticQuantity(Unit.FEET, 6), new Bester(QtyList).best());

    }




}
