package LIC;
import parameters.Parameters;

/** 
 *   There exists at least one set of three consecutive data points which form an angle such that:
 *   angle < (PI−EPSILON)
 *  or
 *   angle > (PI+EPSILON)
 *   The second of the three consecutive points is always the vertex of the angle. If either the first
 *   point or the last point (or both) coincides with the vertex, the angle is undefined and the LIC
 *   is not satisfied by those three points.
 *   (0 ≤ EPSILON < PI)
*/
public class LIC2 implements LIC {
    
    /**
     * Evaluates LIC #2
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the amount of points
     * @param POINTSX an array of the x-coordinates of all points
     * @param POINTSY an array of the y-coordinates of all points
     * @return a boolean stating whether the 2:nd LIC is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {

        assert(0 <= p.EPSILON && p.EPSILON < Math.PI);

        if (NUMPOINTS < 3) {
            return false;
        }
        
        for (int i = 0; i < NUMPOINTS-2; i++){
            // Point A
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            // Point B
            double vx = POINTSX[i+1];
            double vy = POINTSY[i+1];
            // Point C
            double x2 = POINTSX[i+2];
            double y2 = POINTSY[i+2];

            if (Utils.isAngleOutsideInterval(vx, vy, x1, y1, x2, y2, p.EPSILON)) {
                return true;
            }
        }
        return false;
    }
}
