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
            if(dist(POINTSX[i], POINTSY[i], POINTSX[i+1], POINTSY[i+1]) > p.LENGTH1){
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the distance between two data points.
     * @param x1 x-coordinate of point 1
     * @param y1 y-coordinate of point 1
     * @param x2 x-coordinate of point 2
     * @param y2 y-coordinate of point 2
     * @return The Euclidean distance between two points in a two-dimensional plane
     */
    private double dist(double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1, 2));
        return dist;
    }
}
