package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import parameters.Parameters;
import LIC.LIC4;

public class LIC4Test {

   /*  *
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    
    @Test
    public void assertThatQ_PTSOutsideBoundsThrowsException() {
        Parameters p = new Parameters();
        p.Q_PTS = 1;
        p.QUADS = 1;
        int NUMPOINTS = 3;
        double[] POINTSX = {0.0,1.0,2.0};
        double[] POINTSY = {0.0,1.0,2.0};
        assertThrows(AssertionError.class, () -> {(new LIC4()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    @Test
    public void assertThatQUADSOutsideBoundsThrowsException() {
        Parameters p = new Parameters();
        int NUMPOINTS = 2;
        p.Q_PTS = 1;
        p.QUADS = 5;
        double[] POINTSX = {0.0,1.0};
        double[] POINTSY = {0.0,1.0};
        assertThrows(AssertionError.class, () -> {(new LIC4()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }
    
    @Test
    public void assertThatTooFewPointsThrowsException() {
        Parameters p = new Parameters();
        int NUMPOINTS = 1;
        p.Q_PTS = 2;
        p.QUADS = 1;
        double[] POINTSX = {0.0};
        double[] POINTSY = {0.0};
        assertThrows(AssertionError.class, () -> {(new LIC4()).evaluate(p,NUMPOINTS,POINTSX,POINTSY);});
    }

    /**
     * NEGATIVE TESTS
     * Tests that function returns false when input does not satisfy LIC#4
     */

    @Test
    public void assertThatTooFewQuadsReturnsFalse() {
        Parameters p = new Parameters();
        int NUMPOINTS = 3;
        p.Q_PTS = 2;
        p.QUADS = 3;
        double[] POINTSX = {1.0,3.0,2.0};
        double[] POINTSY = {2.0,5.0,4.0};
        assertFalse((new LIC4()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatTooFewQuadsManyPointsReturnsFalse() {
        Parameters p = new Parameters();
        int NUMPOINTS = 9;
        p.Q_PTS = 3;
        p.QUADS = 3;
        double[] POINTSX = {1.0,1.0,1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0};
        double[] POINTSY = {1.0,1.0,1.0,1.0,1.0,1.0,-1.0,-1.0,-1.0};
        assertFalse((new LIC4()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    /**
     * PASSING TESTS
     * Tests that function returns true when input satisfies LIC #6. 
     */
    @Test
    public void assertThatAmbiguousPointsReturnTrue(){
        Parameters p = new Parameters();
        p.Q_PTS = 3;
        p.QUADS = 2;
        int NUMPOINTS = 3;
        double[] POINTSX = {0.0,-1.0,0.0};
        double[] POINTSY = {1.0,0.0,-1.0};        
        assertTrue((new LIC4()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatValidInputReturnsTrue() {
        Parameters p = new Parameters();
        p.Q_PTS = 3;
        p.QUADS = 2;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0,-1.0,1.0};
        double[] POINTSY = {1.0,-1.0,-5.0};        
        assertTrue((new LIC4()).evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}
