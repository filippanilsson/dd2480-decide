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
public class LIC2 {
    
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
            double x2 = POINTSX[i+1];
            double y2 = POINTSY[i+1];
            // Point C
            double x3 = POINTSX[i+2];
            double y3 = POINTSY[i+2];

            if((x1 == x2 && y1 == y2) || (x2 == x3 && y2 == y3)) {
                return false;
            }

            double angle1 = Math.atan2(y1 - y2, x1 - x2);
            double angle2 = Math.atan2(y3 - y2, x3 - x2);
            double angle = angle1 - angle2;
        
            // Ensure the angle is between 0 and 2π
            if (angle < 0) {
                angle += 2 * Math.PI;
            }
            
            if (angle < (Math.PI - p.EPSILON) || angle > (Math.PI + p.EPSILON)) {
                return true;
            }
        }
        return false;
    }
}
