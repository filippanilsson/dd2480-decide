package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #12
 * <p>
 * There exists at least one set of two data points, separated by exactly K_PTS consecutive intervening points, which are a distance greater than the length, LENGTH1, apart. In addition, there exists at least one set of two data points (which can be the same or different from the two data points just mentioned), separated by exactly K_PTS consecutive intervening points, that are a distance less than the length, LENGTH2, apart. Both parts must be true for the LIC to be true. The condition is not met when NUMPOINTS < 3.
 * </p>
 * (0 ≤ LENGTH2)
 */
public class LIC12 implements LIC {
    /**
     * Evaluates LIC #12
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the amount of points
     * @param POINTSX an array of the x-coordinates of all points
     * @param POINTSY an array of the y-coordinates of all points
     * @return a boolean stating whether the 12:th LIC is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        assert(NUMPOINTS >= 3);
        assert(0 <= p.LENGTH1);
        assert(0 <= p.LENGTH2);
        assert(1 <= p.K_PTS && p.K_PTS <= NUMPOINTS-2);
        

        boolean existsDistGreaterThanLength1 = false;
        boolean existsDistLessThanLength2 = false;
        int distToOtherPoint = 1 + p.K_PTS;
        for (int point = 0; point < NUMPOINTS-distToOtherPoint && 
                !(existsDistGreaterThanLength1 && existsDistLessThanLength2); point++) {
            int otherPoint = point + distToOtherPoint;
            double distance = Utils.dist(POINTSX[point], POINTSY[point], POINTSX[otherPoint], POINTSY[otherPoint]);
            if (distance > p.LENGTH1) {
                existsDistGreaterThanLength1 = true;
            }
            if (distance < p.LENGTH2) {
                existsDistLessThanLength2 = true;
            }
        }

        return existsDistGreaterThanLength1 && existsDistLessThanLength2;
    }
}
