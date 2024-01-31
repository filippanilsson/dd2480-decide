package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import parameters.Parameters;
import LIC.LIC3;

public class LIC3Test {

    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    
    @Test
    public void assertThatTooSmallAreaThrowsException() {
        Parameters p = new Parameters();
        p.AREA1 = -1.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {0.0,1.0,2.0};
        double[] POINTSY = {0.0,1.0,2.0};
        assertThrows(AssertionError.class, () -> {
            (new LIC3()).evaluate(p, NUMPOINTS, POINTSX, POINTSY);
        });
    }
    
    /*
     * ------ FAILING TESTS ------
     * Tests that the function evaluates to false when supposed to
     */
    
    @Test
    public void assertThatLIC3ReturnsFalseWithTooFewPoints(){
        Parameters p = new Parameters();
        p.AREA1 = 1;
        int NUMPOINTS = 2;
        double[] POINTSX = {0.0,1.0};
        double[] POINTSY = {0.0,1.0};
        assertFalse((new LIC3()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }
    
    @Test
    public void assertThatLIC3ReturnsFalseWithInvalidInput() {
        Parameters p = new Parameters();
        p.AREA1 = 1.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {0.0,1.0,0.0};
        double[] POINTSY = {0.0,0.0,1.0};
        assertFalse((new LIC3()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
    
    /**
     * PASSING TESTS
     * Tests that function returns true when input satisfies LIC #3. 
     */
    
    @Test
    public void assertThatLIC3ReturnsTrueWithValidInput(){
        Parameters p = new Parameters();
        p.AREA1 = 0.5;
        int NUMPOINTS = 3;
        double[] POINTSX = {0.0,1.0,2.0};
        double[] POINTSY = {0.0,1.0,0.0};   
        assertTrue((new LIC3()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
        
    }
}