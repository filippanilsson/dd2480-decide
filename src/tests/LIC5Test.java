package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import parameters.Parameters;
import LIC.LIC5;

public class LIC5Test {


    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    @Test
    public void assertThatTooFewPointsThrowsException() {
        Parameters p = new Parameters();
        int NUMPOINTS = 1;
        double[] POINTSX = {1.0};
        double[] POINTSY = {1.0};
        assertThrows(AssertionError.class, () -> {(new LIC5()).evaluate(p, NUMPOINTS, POINTSX, POINTSY);});
    }
    

    /*
     * ------ FAILING TESTS ------
     * Tests that the function evaluates to false when supposed to
     */
    
    
    @Test
    public void assertThatReturnsFalseForInvalidInput() {
        Parameters p = new Parameters();
        int NUMPOINTS = 2;
        double[] POINTSX = {1.0, 2.0};
        double[] POINTSY = {1.0, 2.0};
        assertFalse((new LIC5()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
    
    /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to true when supposed to
     */
     @Test
    public void assertThatReturnsTrueForValidInput() {
        Parameters p = new Parameters();
        int NUMPOINTS = 2;
        double[] POINTSX = {2.0, 1.0};
        double[] POINTSY = {2.0, 1.0};
        assertTrue((new LIC5()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}