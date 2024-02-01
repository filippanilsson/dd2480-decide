package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import parameters.Parameters;
import LIC.LIC8;

public class LIC8Test {

    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    @Test
    public void assertThatTooFewPointsThrowsException() {
        Parameters p = new Parameters();
        p.K_PTS = 1;
        p.LENGTH1 = 1;
        int NUMPOINTS = 2;
        double[] POINTSX = {0.0,1.0};
        double[] POINTSY = {0.0,1.0};
        assertThrows(AssertionError.class, () -> {(new LIC8()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatTooSmallAPTSRaisesError() {
        Parameters p = new Parameters();
        p.A_PTS = 0;
        p.B_PTS = 1;
        p.RADIUS1 = 1;
        int NUMPOINTS = 5;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0};
        assertThrows(AssertionError.class, () -> {(new LIC8()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatTooSmallBPTSRaisesError() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 0;
        p.RADIUS1 = 1;
        int NUMPOINTS = 5;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0};
        assertThrows(AssertionError.class, () -> {(new LIC8()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatTooLargeAPTSBPTSRaisesError() {
        Parameters p = new Parameters();
        p.A_PTS = 2;
        p.B_PTS = 2;
        p.RADIUS1 = 1;
        int NUMPOINTS = 5;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0};
        assertThrows(AssertionError.class, () -> {(new LIC8()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatInvalidRADIUS1RaisesError() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 1;
        p.RADIUS1 = -1;
        int NUMPOINTS = 5;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0};
        assertThrows(AssertionError.class, () -> {(new LIC8()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    /**
     * FAILING TESTS
     * Tests that evaluate function returns false when input does not satisfy LIC #8.
     */

   

    @Test
    public void assertThatMaxCircleLessThanRADIUS1ReturnsFalse() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 2;
        p.RADIUS1 = 1;
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};
        assertFalse((new LIC8()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    /**
     * PASSING TESTS
     * Tests that evaluate function returns true when input satisfies LIC #8. 
     */

    @Test
    public void assertThatMaxCircleGreaterThanRADIUS1ReturnsTrue() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 1;
        p.RADIUS1 = 1;
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};
        assertTrue((new LIC8()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

}