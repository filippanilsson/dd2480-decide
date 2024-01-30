package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LIC1Test {

    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */

    @Test
    public void assertThatTooSmallRadiusThrowsException() {
        Parameters p = new Parameters();
        p.RADIUS1 = -0.1;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 2.0, 3.0};
        double[] POINTSY = {1.0, 2.0, 3.0};
        
        assertThrows(AssertionError.class, () -> {(new LIC1()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    /*
     * ------ FAILING TESTS ------
     * Tests that the function evaluates to false when supposed to
     */

    @Test
    public void assertThatLIC1ReturnsFalseWithInvalidCriteria() {
        Parameters p = new Parameters();
        p.RADIUS1 = 3.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 2.0, 3.0};
        double[] POINTSY = {1.0, 2.0, 3.0};
     
        assertFalse((new LIC1()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatLIC1ReturnsFalseForSmallObtuseTriangle(){
        Parameters p = new Parameters();
        p.RADIUS1 = 1.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {-1.0, 0.0, 1.0};
        double[] POINTSY = {0.0, 0.5, 0.0};

        assertFalse((new LIC1()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to true when supposed to
     */

    @Test
    public void assertThatLIC1ReturnsTrueWithValidCriteria(){
        Parameters p = new Parameters();
        p.RADIUS1 = 1.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 2.0, 3.0};
        double[] POINTSY = {1.0, 2.0, 3.0};
  
        assertTrue((new LIC1()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatLIC1ReturnsTrueForLargeAcuteTriangle(){
        Parameters p = new Parameters();
        p.RADIUS1 = 1.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {-1.0, 0.0, 1.0};
        double[] POINTSY = {0.0, 1.5, 0.0};

        assertTrue((new LIC1()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}
