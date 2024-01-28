package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;
import parameters.Parameters;
import LIC.LIC14;

public class LIC14Test {

    /*
     * ------ FAILING TESTS ------
     * Tests that the function evaluates to false when supposed to
     */
    @Test
    public void assertThatTooFewPointsReturnFalse() {
        Parameters p = new Parameters();
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 4;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC14 lic14 = new LIC14();
        assertFalse(lic14.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatArea2LessThanZeroReturnsFalse() {
        Parameters p = new Parameters();
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        p.AREA2 = -5;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC14 lic14 = new LIC14();
        assertFalse(lic14.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatAreaSmallerThanArea1ReturnsFalse() {
        Parameters p = new Parameters();
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3.5;
        p.AREA2 = 5;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC14 lic14 = new LIC14();
        assertFalse(lic14.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatAreaGreaterThanArea2ReturnsFalse() {
        Parameters p = new Parameters();
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3.5;
        p.AREA2 = 0.4;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC14 lic14 = new LIC14();
        assertFalse(lic14.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to true when supposed to
     */
    @Test
    public void assertThatValidCriteriaReturnTrue() {
        Parameters p = new Parameters();
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        p.AREA2 = 5;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC14 lic14 = new LIC14();
        assertTrue(lic14.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}