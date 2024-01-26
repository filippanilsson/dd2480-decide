package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LICTest {

    @Test
    public void coordinateArraysSameLengthAsNUMPOINTS() {
        int NUMPOINTS = 8;
        double[] POINTSXsameLength = {0.763, 1.245, 0.982, 2.573, 0.431, 1.789, 0.624, 3.142};
        double[] POINTSYsameLength = {0.891, 1.674, 0.512, 2.315, 0.743, 1.892, 0.421, 3.789};

        assertEquals(POINTSXsameLength.length, NUMPOINTS);
        assertEquals(POINTSYsameLength.length, NUMPOINTS);
    }

    @Test 
    public void testLIC0() {
        Parameters p = new Parameters(0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        LIC0 lic0 = new LIC0();
        assertTrue(lic0.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

}