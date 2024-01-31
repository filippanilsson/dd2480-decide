package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #13
 * <p>
 * There exists at least one set of three data points, separated by exactly A_PTS and B_PTS consecutive intervening points, respectively, that cannot be contained within or on a circle of radius RADIUS1. In addition, there exists at least one set of three data points (which can be the same or different from the three data points just mentioned) separated by exactly A_PTS and B_PTS consecutive intervening points, respectively, that can be contained in or on a circle of radius RADIUS2. Both parts must be true for the LIC to be true. 
 * The condition is not met when NUMPOINTS < 5. 
 * 0 ≤ RADIUS2 
 * </p>
 */
public class LIC13 implements LIC {
    /**
     * Evaluates LIC #13
     * 
     * @param p         Parameters object that contains all constant values
     * @param NUMPOINTS the amount of points
     * @param POINTSX   an array of the x-coordinates of all points
     * @param POINTSY   an array of the y-coordinates of all points
     * @return a boolean stating whether the 1:st LIC is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        assert(0 <= p.RADIUS2);
        assert(1 <= p.A_PTS);
        assert(1 <= p.B_PTS);
        assert(p.A_PTS+p.B_PTS <= NUMPOINTS-3);
        
        boolean existsPointsNotContainedInRadius1 = false;
        boolean existsPointsContainedInRadius2 = false;
        for (int i = 0; i < NUMPOINTS - p.A_PTS - p.B_PTS - 2 &&
                !(existsPointsNotContainedInRadius1 && existsPointsContainedInRadius2); i++) {
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i + p.A_PTS + 1];
            double y2 = POINTSY[i + p.A_PTS + 1];
            double x3 = POINTSX[i + p.A_PTS + p.B_PTS + 2];
            double y3 = POINTSY[i + p.A_PTS + p.B_PTS + 2];

            double minEnclosingRadius = Utils.minEnclosingRadius(x1, y1, x2, y2, x3, y3);

            if (minEnclosingRadius > p.RADIUS1) {
                existsPointsNotContainedInRadius1 = true;
            }
            if (minEnclosingRadius < p.RADIUS2) {
                existsPointsContainedInRadius2 = true;
            }
        }
        return existsPointsNotContainedInRadius1 && existsPointsContainedInRadius2;
    }
}
