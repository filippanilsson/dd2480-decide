package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #11
 * <p>
 * There exists at least one set of two data points, (X[i],Y[i]) and (X[j],Y[j]), separated by exactly G_PTS consecutive 
 * intervening points, such that X[j] - X[i] < 0. (where i < j ) The condition is not met when NUMPOINTS < 3.
 * 1 ≤ G_PTS ≤ NUMPOINTS−2
 * </p>
 */
public class LIC11 implements LIC {
    /**
     * Evaluates LIC #11
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the amount of points
     * @param POINTSX an array of the x-coordinates of all points
     * @param POINTSY an array of the y-coordinates of all points
     * @return a boolean stating whether the 11:th LIC is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        //Bounder
        if (NUMPOINTS < 3) {
            return false;
        }
        assert(1 <= p.G_PTS);
        assert(p.G_PTS <= NUMPOINTS - 2);

        for(int i = 0; i < NUMPOINTS - p.G_PTS - 1; ++i) {
            double x1 = POINTSX[i];
            double x2 = POINTSX[i + p.G_PTS + 1];

            //Check if the set satisfy the condition
            if(x2 - x1 < 0) {
                return true;
            }
        }
        return false;
    }
}
