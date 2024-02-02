package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import parameters.Parameters;
import LIC.LIC7;

public class LIC7Test {

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
        assertThrows(AssertionError.class, () -> {(new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }


    @Test
    public void assertThatTooSmallKPTSRaisesError() {
        Parameters p = new Parameters();
        p.K_PTS = 0;
        p.LENGTH1 = 1;
        int NUMPOINTS = 5;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0};
        assertThrows(AssertionError.class, () -> {(new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatTooLargeKPTSRaisesError() {
        Parameters p = new Parameters();
        p.K_PTS = 4;
        p.LENGTH1 = 1;
        int NUMPOINTS = 5;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0};
        assertThrows(AssertionError.class, () -> {(new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatInvalidLENGTH1RaisesError() {
        Parameters p = new Parameters();
        p.K_PTS = 4;
        p.LENGTH1 = -1;
        int NUMPOINTS = 5;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0};
        assertThrows(AssertionError.class, () -> {(new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    /**
     * NEGATIVE TESTS
     * Tests that evaluate function returns false when input does not satisfy LIC #7.
     */

   

    @Test
    public void assertThatDistLessThanLENGTH1ReturnsFalse() {
        Parameters p = new Parameters();
        p.K_PTS = 2;
        p.LENGTH1 = 4;
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{0.5, 1.2, 1.5, 1.8, 2.1, 4.0};
        double[] POINTSY = new double[]{0.4, 3.1, 1.0, 3.0, 5.7, 3.1};
        assertFalse((new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    /**
     * PASSING TESTS
     * Tests that evaluate function returns true when input satisifies LIC #7. 
     */

    @Test
    public void assertThatDistGreaterThanLENGTH1ReturnsTrue() {
        Parameters p = new Parameters();
        p.K_PTS = 1;
        p.LENGTH1 = 4;
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{0.5, 1.2, 1.5, 1.8, 2.1, 4.0};
        double[] POINTSY = new double[]{0.4, 3.1, 1.0, 3.0, 5.7, 3.1};
        assertTrue((new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

}
