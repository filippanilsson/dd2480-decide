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
            double dist = Utils.dist(POINTSX[i], POINTSY[i], POINTSX[i+p.K_PTS+1], POINTSY[i+p.K_PTS+1]);
            if (dist > p.LENGTH1) return true;
        }
        return false;
    }
}

