package tests;

import parameters.Parameters;
import org.junit.Test;
import static org.junit.Assert.*;
import LIC.LIC11;

public class LIC11Test {
    Parameters p = new Parameters();

    @Test
    public void assertThatValidCriteriaReturnTrue() {
        p.G_PTS = 1;
        int NUMPOINTS = 8;

        double[] POINTSX = {3, 2, 1, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC11 lic11 = new LIC11();
        assertTrue(lic11.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatInvalidCriteriaReturnFasle() {
        p.G_PTS = 1;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC11 lic11 = new LIC11();
        assertFalse(lic11.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatTooFewPointsReturnFalse() {
        p.G_PTS = 1;
        int NUMPOINTS = 2;

        double[] POINTSX = {3, 2};
        double[] POINTSY = {0, 1};
        LIC11 lic11 = new LIC11();
        assertFalse(lic11.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatGPTSLessThan1ReturnFasle() {
        p.G_PTS = 0;
        int NUMPOINTS = 8;

        double[] POINTSX = {3, 2, 1, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC11 lic11 = new LIC11();
        assertThrows(AssertionError.class, () -> {lic11.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatGPTSGreaterThanNumpointsReturnFasle() {
        p.G_PTS = 7;
        int NUMPOINTS = 8;

        double[] POINTSX = {3, 2, 1, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC11 lic11 = new LIC11();
        assertThrows(AssertionError.class, () -> {lic11.evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }
}
