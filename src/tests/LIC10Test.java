package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LIC10Test {
    Parameters p = new Parameters();

    /**
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */

    @Test 
    public void assertThatTooFewPointsThrowsException(){
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 1;

        double[] POINTSX = {0};
        double[] POINTSY = {0};
        LIC10 lic10 = new LIC10();
        assertThrows(AssertionError.class, () -> {lic10.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatEPTSLessThan1ThrowsException() {
        p.E_PTS = 0;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertThrows(AssertionError.class, () -> {lic10.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatFPTSLessThan1ThrowsException() {
        p.E_PTS = 1;
        p.F_PTS = 0;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertThrows(AssertionError.class, () -> {lic10.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatEPTSPlusFPTSTooLargeThrowsException() {
        p.E_PTS = 2;
        p.F_PTS = 4;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertThrows(AssertionError.class, () -> {lic10.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatAreaLessThan0ThrowsException() {
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = -1;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertThrows(AssertionError.class, () -> {lic10.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    /**
     * NEGATIVE TESTS
     * Tests that evaluate function returns false when input does not satisfy LIC #10.
     */

    @Test
    public void assertThatInvalidCriteriaReturnFalse() {
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC10 lic10 = new LIC10();
        assertFalse(lic10.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    /**
     * PASSING TESTS
     * Tests that evaluate function returns true when input satisfies LIC #10. 
     */
    
    @Test
    public void assertThatValidCriteriaReturnTrue() {
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertTrue(lic10.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}
