package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LIC9Test {
    Parameters p = new Parameters();
    
    @Test
    public void assertThatValidCriteriaWithLargeEpsilonReturnTrue() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertTrue(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatValidCriteriaWithSmallEpsilonReturnTrue() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 0.1;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1.5, 2, 1, 0, 1.5};
        LIC9 lic9 = new LIC9();
        assertTrue(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatValidCriteriaReturnFalse() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1.5, 2, 1, 0, 1.5};
        LIC9 lic9 = new LIC9();
        assertFalse(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatTooFewPointsReturnFalse() {
        p.C_PTS = 1;
        p.D_PTS = 1;
        p.EPSILON = 0.01;
        int NUMPOINTS = 4;

        double[] POINTSX = {0, 1, 2, 3};
        double[] POINTSY = {0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertFalse(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatCPTSLessThan1ReturnFalse() {
        p.C_PTS = 0;
        p.D_PTS = 1;
        p.EPSILON = 0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertFalse(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatDPTSLessThan1ReturnFalse() {
        p.C_PTS = 1;
        p.D_PTS = 0;
        p.EPSILON = 0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertFalse(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatCPTSPlusDPTSGreaterThanNumPointsReturnFalse() {
        p.C_PTS = 2;
        p.D_PTS = 4;
        p.EPSILON = 0.01;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC9 lic9 = new LIC9();
        assertFalse(lic9.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}
