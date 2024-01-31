package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #0
 * There exists at least one set of two consecutive data points that are a distance greater than the length, LENGTH1, apart.
 *  (0 ≤ LENGTH1)
 */
public class LIC0 implements LIC {
    
    /**
     * Evaluates LIC #0
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the amount of points
     * @param POINTSX an array of the x-coordinates of all points
     * @param POINTSY an array of the y-coordinates of all points
     * @return a boolean stating whether the 0:th LIC is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {

        assert(0 <= p.LENGTH1);

        for(int i = 0; i < NUMPOINTS-1 ; i++){
            if(Utils.dist(POINTSX[i], POINTSY[i], POINTSX[i+1], POINTSY[i+1]) > p.LENGTH1){
                return true;
            }
        }
        return false;
    }
}
