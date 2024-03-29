package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import parameters.Parameters;
import LIC.LIC12;

public class LIC12Test {
    /**
     * ------ INVALID INPUT TESTS ------
     * Tests that the function raises an exception when given invalid parameter input.
     */

    @Test
    public void assertThatTooFewPointsThrowsException() {
        Parameters p = new Parameters();

        p.K_PTS = 1;
        p.LENGTH1 = 1;
        p.LENGTH2 = 1;

        int NUMPOINTS = 2;
        double[] POINTSX = {0.0, 0.0};
        double[] POINTSY = {0.0, 0.0};

        LIC12 lic12 = new LIC12();
        assertThrows(AssertionError.class, () -> {lic12.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatLength1NegativeThrowsException() {
        Parameters p = new Parameters();

        p.K_PTS = 1;
        p.LENGTH1 = -1;
        p.LENGTH2 = 1;

        int NUMPOINTS = 3;
        double[] POINTSX = {0.0, 0.0, 0.0};
        double[] POINTSY = {0.0, 0.0, 0.0};

        LIC12 lic12 = new LIC12();
        assertThrows(AssertionError.class, () -> {lic12.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatLength2NegativeThrowsException() {
        Parameters p = new Parameters();

        p.K_PTS = 1;
        p.LENGTH1 = 1;
        p.LENGTH2 = -1.0;

        int NUMPOINTS = 3;
        double[] POINTSX = {0.0, 0.0, 0.0};
        double[] POINTSY = {0.0, 0.0, 0.0};

        LIC12 lic12 = new LIC12();
        assertThrows(AssertionError.class, () -> {lic12.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatKptsTooLargeThrowsException() {
        Parameters p = new Parameters();
        p.K_PTS = 2;
        p.LENGTH1 = 1;
        p.LENGTH2 = 1;

        int NUMPOINTS = 3;
        double[] POINTSX = {0.0, 0.0, 0.0};
        double[] POINTSY = {0.0, 0.0, 0.0};

        LIC12 lic12 = new LIC12();
        assertThrows(AssertionError.class, () -> {lic12.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }
    

    /*
     * ------ NEGATIVE TESTS ------
     * Tests that the function evaluates to false when supposed to
     */

    @Test
    public void assertThatDistLessThanLength1ReturnsFalse() {
        Parameters p = new Parameters();
        p.K_PTS = 1;
        p.LENGTH1 = 10.0;
        p.LENGTH2 = 1;

        int NUMPOINTS = 3;
        double[] POINTSX = {0.0, 0.0, 0.0};
        double[] POINTSY = {0.0, 0.0, 0.0};

        LIC12 lic12 = new LIC12();
        assertFalse(lic12.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatDistGreaterThanLength2ReturnsFalse() {
        Parameters p = new Parameters();
        p.K_PTS = 1;
        p.LENGTH1 = 1.0;
        p.LENGTH2 = 2.0;

        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 0.0, 3.0};
        double[] POINTSY = {0.0, 0.0, 1.0};

        LIC12 lic12 = new LIC12();
        assertFalse(lic12.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to true when supposed to
     */
    @Test
    public void assertThatValidCriteriaReturnsTrue() {
        Parameters p = new Parameters();
        p.K_PTS = 1;
        p.LENGTH1 = 1.0;
        p.LENGTH2 = 3.0;

        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 0.0, 3.0};
        double[] POINTSY = {0.0, 0.0, 1.0};

        LIC12 lic12 = new LIC12();
        assertTrue(lic12.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}
