package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LIC10Test {
    Parameters p = new Parameters();
    
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

    @Test
    public void assertThatValidCriteriaReturnFalse() {
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 0, 1, 0, 1, 0, 1};
        LIC10 lic10 = new LIC10();
        assertFalse(lic10.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatTooFewPointsReturnFalse() {
        p.E_PTS = 1;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 4;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertFalse(lic10.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatEPTSLessThan1ReturnFalse() {
        p.E_PTS = 0;
        p.F_PTS = 1;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertFalse(lic10.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatFPTSLessThan1ReturnFalse() {
        p.E_PTS = 1;
        p.F_PTS = 0;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertFalse(lic10.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatEPTSPlusFPTSGreaterThanNumPointsReturnFalse() {
        p.E_PTS = 2;
        p.F_PTS = 4;
        p.AREA1 = 3;
        int NUMPOINTS = 8;

        double[] POINTSX = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] POINTSY = {0, 1, 1.5, 2, 2.5, 1.5, 0, 1};
        LIC10 lic10 = new LIC10();
        assertFalse(lic10.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    
}
