package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LIC9Test {
    Parameters p = new Parameters();

    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */

    @Test
    public void assertThatCPTSLessThan1RaisesException() {
        p.C_PTS = 0;
        p.D_PTS = 1;
        p.EPSILON = 0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertThrows(AssertionError.class, () -> {lic9.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatDPTSLessThan1RaisesException() {
        p.C_PTS = 1;
        p.D_PTS = 0;
        p.EPSILON = 0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertThrows(AssertionError.class, () -> {lic9.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatEPSILONLessThan0RaisesException() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = -0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertThrows(AssertionError.class, () -> {lic9.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatCPTSPlusDPTSTooLargeRaisesException() {
        p.C_PTS = 2;
        p.D_PTS = 4;
        p.EPSILON = 0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertThrows(AssertionError.class, () -> {lic9.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    /**
     * FAILING TESTS
     * Tests that evaluate function returns false when input does not satisfy LIC #9.
     */

     @Test
    public void assertThatTooFewPointsReturnFalse() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 3;
        int NUMPOINTS = 4;

        double[] POINTSX = {0, 1, 2, 3};
        double[] POINTSY = {0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertFalse(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatInvalidCriteriaReturnFalse() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 1.6;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1.5, 2, 1, 0, 1.5};
        LIC9 lic9 = new LIC9();
        assertFalse(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    /**
     * PASSING TESTS
     * Tests that evaluate function returns true when input satisfies LIC #9. 
     */
    
    @Test
    public void assertThatValidCriteriaWithLargeEpsilonReturnTrue() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 3};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 0.9};
        LIC9 lic9 = new LIC9();
        assertTrue(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatValidCriteriaWithSmallEpsilonReturnTrue() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1.5, 2, 1, 0, 1.5};
        LIC9 lic9 = new LIC9();
        assertTrue(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}
