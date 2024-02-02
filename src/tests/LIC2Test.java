package tests;

import parameters.Parameters;
import org.junit.Test;
import static org.junit.Assert.*;
import LIC.LIC2;

public class LIC2Test {
    
    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */

    @Test
    public void assertThatTooFewPointsThrowsException() {
        Parameters p = new Parameters();

        p.EPSILON = Math.PI/2;
        int NUMPOINTS = 2;
        double[] POINTSX = {1.0, 1.0};
        double[] POINTSY = {1.0, 1.0};

        assertThrows(AssertionError.class, () -> {(new LIC2()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }
   
    @Test
    public void assertThatTooSmallEpsilonThrowsException() {
        Parameters p = new Parameters();

        p.EPSILON = -0.1;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 2.0, 3.0};
        double[] POINTSY = {1.0, 2.0, 3.0};
        LIC2 lic2 = new LIC2();

        assertThrows(AssertionError.class, () -> {
            lic2.evaluate(p, NUMPOINTS, POINTSX, POINTSY);
        });
    }

    /*
     * ------ NEGATIVE TESTS ------
     * Tests that the function evaluates to false when supposed to
     */
    
    @Test
    public void assertThatLIC2ReturnsFalseWithCoincidingPoints(){
        Parameters p = new Parameters();

        p.EPSILON = Math.PI/2;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 1.0, 3.0};
        double[] POINTSY = {1.0, 1.0, 3.0};
        LIC2 lic2 = new LIC2();
        assertFalse(lic2.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
        
    }

   @Test
   public void assertFalseWhenAngleOutOfBounds() {
        Parameters p = new Parameters();
        p.EPSILON = Math.PI/2;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 2.0, 3.0};
        double[] POINTSY = {1.0, 2.0, 3.0};
        LIC2 lic2 = new LIC2();
        assertFalse(lic2.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
   }

    /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to true when supposed to
     */

    @Test
    public void assertThatLIC2ReturnsTrueWithValidInput(){
        Parameters p = new Parameters();

        p.EPSILON = Math.PI/2;
        int NUMPOINTS = 3;
        double[] POINTSX = {4.0, 1.0, 3.0};
        double[] POINTSY = {4.0, 1.0, 3.0};
        LIC2 lic2 = new LIC2();
        assertTrue(lic2.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

}
