package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LIC0Test {

    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    @Test
    public void assertThatLIC0ReturnsFalseWithInvalidCriteria() {
        Parameters p = new Parameters();
        p.LENGTH1 = 2.0;
        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
     
        assertFalse((new LIC0()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatTooSmallLengthThrowsException() {
        Parameters p = new Parameters();
        p.LENGTH1 = -0.1;
        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        
        assertThrows(AssertionError.class, () -> {(new LIC0()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }
   
    /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to true when supposed to
     */

    @Test 
    public void assertsThatLIC0ReturnsTrueWithValidCriteria() {
        Parameters p = new Parameters();
        p.LENGTH1 = 0.5;
        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        
        assertTrue((new LIC0()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}