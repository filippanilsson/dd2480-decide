package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import parameters.Parameters;
import LIC.LIC13;

public class LIC13Test {
     /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    @Test
    public void assertThatRadius2NegativeThrowsException() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 1;
        p.RADIUS1 = 1;
        p.RADIUS2 = -1;

        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};

        LIC13 lic13 = new LIC13();
        assertThrows(AssertionError.class, () -> {lic13.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatAPtsLessThanOneThrowsException() {
        Parameters p = new Parameters();
        p.A_PTS = 0;
        p.B_PTS = 1;
        p.RADIUS1 = 1;
        p.RADIUS2 = 1;

        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};

        LIC13 lic13 = new LIC13();
        assertThrows(AssertionError.class, () -> {lic13.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatBPtsLessThanOneThrowsException() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 0;
        p.RADIUS1 = 1;
        p.RADIUS2 = 1;

        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};

        LIC13 lic13 = new LIC13();
        assertThrows(AssertionError.class, () -> {lic13.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }


    /**
     * FAILING TESTS
     * Tests that evaluate function returns false when input does not satisfy LIC #13.
     */
    @Test
    public void assertThatTooFewPointsReturnFalse() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 1;
        p.RADIUS1 = 1;

        int NUMPOINTS = 2;
        double[] POINTSX = {0.0,1.0};
        double[] POINTSY = {0.0,1.0};

        LIC13 lic13 = new LIC13();
        assertFalse(lic13.evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    @Test
    public void assertThatContainedInRadius1ReturnsFalse() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 1;
        p.RADIUS1 = 10;
        p.RADIUS2 = 1;

        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};
        
        LIC13 lic13 = new LIC13();
        assertFalse(lic13.evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    @Test
    public void assertThatNotContainedInRadius2ReturnsFalse() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 1;
        p.RADIUS1 = 1;
        p.RADIUS2 = 0.5;

        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};

        LIC13 lic13 = new LIC13();
        assertTrue(lic13.evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    /**
     * PASSING TESTS
     * Tests that evaluate function returns true when input satisfies LIC #13. 
     */

    @Test
    public void assertThatMaxCircleGreaterThanRADIUS1ReturnsTrue() {
        Parameters p = new Parameters();
        p.A_PTS = 1;
        p.B_PTS = 1;
        p.RADIUS1 = 1;
        p.RADIUS2 = 1;

        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{1.0,2.0,1.0,2.5,2.6,2.8};
        double[] POINTSY = new double[]{0.0,0.5,1.0,1.0,2.0,0.2};

        LIC13 lic13 = new LIC13();
        assertTrue(lic13.evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }
}
