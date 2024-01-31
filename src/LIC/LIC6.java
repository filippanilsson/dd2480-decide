package LIC;
import parameters.Parameters;

/** 
 * Evaluates LIC #6
 * 
 * There exists at least one set of N_PTS consecutive data points such that at least one of the
points lies a distance greater than DIST from the line joining the first and last of these N_PTS
points. If the first and last points of these N_PTS are identical, then the calculated distance
to compare with DIST will be the distance from the coincident point to all other points of
the N_PTS consecutive points. The condition is not met when NUMPOINTS < 3.
(3 ≤ N_PTS ≤ NUMPOINTS), (0 ≤ DIST)
 */
public class LIC6 implements LIC {

    /**
     * Evaluates LIC #6
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the number of planar points
     * @param POINTSX an array of the x-coordinates of the planar points
     * @param POINTSY an array of the y-coordinates of the planar points
     * @return a boolean indicating whether LIC 6 is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        if (NUMPOINTS < 3) return false;
        assert(3 <= p.N_PTS && p.N_PTS <= NUMPOINTS);
        assert(0 <= p.DIST);
        for (int i = 0; i < NUMPOINTS-p.N_PTS+1; i++) {            
            for (int j = i+1; j < i+p.N_PTS-1; j++) {
                double x1 = POINTSX[i];
                double y1 = POINTSY[i];
                double x = POINTSX[j];
                double y = POINTSY[j];
                double x2 = POINTSX[i+p.N_PTS-1];
                double y2 = POINTSY[i+p.N_PTS-1];
                double dist;
                if (Utils.arePointsCoincident(x1, y1, x2, y2)) dist = Utils.dist(x1, y1, x, y);
                else dist = Math.abs(((y2-y1)*x-(x2-x1)*y+x2*y1-y2*x1)/Utils.dist(x1, y1, x2, y2));
                if (dist > p.DIST) return true;
            }
        }
        return false;
    }
}

