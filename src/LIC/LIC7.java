package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #7
 * 
 * There exists at least one set of two data points separated by exactly K PTS consecutive intervening points that are a distance greater than the length, LENGTH1, apart. The condition
is not met when NUMPOINTS < 3.
1 ≤ K PTS ≤ (NUMPOINTS − 2)
 */
public class LIC7 implements LIC {

    /**
     * Evaluates LIC #7
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the number of planar points
     * @param POINTSX an array of the x-coordinates of the planar points
     * @param POINTSY an array of the y-coordinates of the planar points
     * @return a boolean indicating whether LIC 7 is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        if (NUMPOINTS < 3) return false;
        assert(0 <= p.LENGTH1);
        assert(1 <= p.K_PTS && p.K_PTS <= NUMPOINTS-2);
        for (int i = 0; i < NUMPOINTS-p.K_PTS-1; i++) {       
            double dist = Math.sqrt(Math.pow(POINTSX[i+p.K_PTS+1]-POINTSX[i],2)+Math.pow(POINTSY[i+p.K_PTS+1]-POINTSY[i],2));
            if (dist > p.LENGTH1) return true;
        }
        return false;
    }

    
    /*@Test
    public static void testLIC7Positive() {
        //Example 1 from the contract: evaluate(p,NUMPOINTS,POINTSX,POINTSY) should return True.
        Parameters p = new Parameters(4, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{0.5, 1.2, 1.5, 1.8, 2.1, 4.0};
        double[] POINTSY = new double[]{0.4, 3.1, 1.0, 3.0, 5.7, 3.1};
        assertTrue((new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }
    
    @Test
    public static void testLIC7Negative() {
        //Example 2 from the contract: evaluate(p,NUMPOINTS,POINTSX,POINTSY) should return False.
        Parameters p = new Parameters(4, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int NUMPOINTS = 6;
        double[] POINTSX = new double[]{0.5, 1.2, 1.5, 1.8, 2.1, 4.0};
        double[] POINTSY = new double[]{0.4, 3.1, 1.0, 3.0, 5.7, 3.1};
        assertFalse((new LIC7()).evaluate(p,NUMPOINTS,POINTSX,POINTSY));
    }

    public static void main(String[] a) {
        testLIC7Positive();
        testLIC7Negative();
    }*/
}

