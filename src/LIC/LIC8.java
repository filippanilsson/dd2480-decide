package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #8
 * 
 * There exists at least one set of three data points separated by exactly A PTS and B PTS
consecutive intervening points, respectively, that cannot be contained within or on a circle of
radius RADIUS1. The condition is not met when NUMPOINTS < 5.
1 ≤ A PTS, 1 ≤ B PTS
A PTS + B PTS ≤ (NUMPOINTS − 3)
 */
public class LIC8 implements LIC {

    /**
     * Evaluates LIC #8
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the number of planar points
     * @param POINTSX an array of the x-coordinates of the planar points
     * @param POINTSY an array of the y-coordinates of the planar points
     * @return a boolean indicating whether LIC 8 is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        assert(NUMPOINTS >= 5);
        assert(1 <= p.A_PTS);
        assert(1 <= p.B_PTS);
        assert(p.A_PTS+p.B_PTS <= NUMPOINTS-3);
        assert(p.RADIUS1 >= 0);
        
        for (int i = 0; i < NUMPOINTS-p.A_PTS-p.B_PTS-2; i++) {
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i + p.A_PTS + 1];
            double y2 = POINTSY[i + p.A_PTS + 1];
            double x3 = POINTSX[i + p.A_PTS + p.B_PTS + 2];
            double y3 = POINTSY[i + p.A_PTS + p.B_PTS + 2];

            double minEnclosingRadius = Utils.minEnclosingRadius(x1, y1, x2, y2, x3, y3);

            if (minEnclosingRadius > p.RADIUS1) return true;
        }
        return false;
    }
}