package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import parameters.Parameters;
import LIC.LIC6;

public class LIC6Test {

    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    @Test
    public void assertThatTooFewPointsThrowsException() {
        Parameters p = new Parameters();
        p.N_PTS = 4;
        p.DIST = 1;
        int NUMPOINTS = 2;
        double[] POINTSX = {0.0,1.0};
        double[] POINTSY = {0.0,1.0};
        assertThrows(AssertionError.class, () -> {(new LIC6()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatInvalidNPTSRaisesError() {
        Parameters p = new Parameters();
        p.N_PTS = 2;
        p.DIST = 1;
        int NUMPOINTS = 3;
        double[] POINTSX = {0.0,1.0,2.0};
        double[] POINTSY = {0.0,1.0,2.0};
        assertThrows(AssertionError.class, () -> {(new LIC6()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatInvalidDISTRaisesError() {
        Parameters p = new Parameters();
        p.N_PTS = 4;
        p.DIST = -1;
        int NUMPOINTS = 3;
        double[] POINTSX = {0.0,1.0,2.0};
        double[] POINTSY = {0.0,1.0,2.0};
        assertThrows(AssertionError.class, () -> {(new LIC6()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    /**
     * NEGATIVE TESTS
     * Tests that evaluate function returns false when input does not satisfy LIC #6.
     */

    @Test
    public void assertThatDistLessThanDISTReturnsFalse() {
        Parameters p = new Parameters();
        p.DIST = 1.11;
        p.N_PTS = 4;
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        double[] POINTSY = new double[]{0.0, 2.0, 2.0, 3.0, 2.0, 4.0};
        assertFalse((new LIC6()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    /**
     * PASSING TESTS
     * Tests that function returns true when input satisfies LIC #6. 
     */

    @Test
    public void assertThatDistToLineGreaterThanDISTReturnsTrue() {
        Parameters p = new Parameters();
        p.DIST = 1;
        p.N_PTS = 4;
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        double[] POINTSY = new double[]{0.0, 2.0, 2.0, 3.0, 2.0, 4.0};
        assertTrue((new LIC6()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    @Test
    public void assertThatDistToCoincidentPointGreaterThanDISTReturnsTrue() {
        Parameters p = new Parameters();
        p.DIST = 1;
        p.N_PTS = 3;
        int NUMPOINTS = 3;
        double[] POINTSX = new double[]{2.0, 1.0, 2.0};
        double[] POINTSY = new double[]{2.0, 1.0, 2.0};
        assertTrue((new LIC6()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

}
