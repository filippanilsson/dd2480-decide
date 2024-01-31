package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #9
 * There exists at least one set of three data points separated by exactly C_PTS and D_PTS consecutive intervening points, respectively, that form an angle such that:
 * angle < (PI−EPSILON)
 * or
 * angle > (PI+EPSILON)
 * The second point of the set of three points is always the vertex of the angle. 
 * If either the first point or the last point (or both) coincide with the vertex, the angle is undefined, and the LIC is not satisfied by those three points. When NUMPOINTS < 5, the condition is not met.
 * 1 ≤ C_PTS, 1 ≤ D_PTS
 * C_PTS + D_PTS ≤ NUMPOINTS−3
*/ 

public class LIC9 implements LIC {

    /**
    * Evaluates LIC #9
    * @param p Parameters object that contains all constant values
    * @param NUMPOINTS the amount of points
    * @param POINTSX an array of the x-coordinates of all points
    * @param POINTSY an array of the y-coordinates of all points
    * @return a boolean stating whether the 9:st LIC is satisfied
    */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        //Bounder
        if(NUMPOINTS < 5)
            return false;

        assert(p.C_PTS >= 1 && p.D_PTS >= 1);
        assert(p.C_PTS + p.D_PTS <= NUMPOINTS - 3);
        assert(p.EPSILON >= 0 && p.EPSILON < Math.PI); 

        for(int i = 0; i < NUMPOINTS - p.C_PTS - p.D_PTS - 2; ++i) {
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double vx = POINTSX[i + p.C_PTS + 1];
            double vy = POINTSY[i + p.C_PTS + 1];
            double x2 = POINTSX[i + p.C_PTS + p.D_PTS + 2];
            double y2 = POINTSY[i + p.C_PTS + p.D_PTS + 2];

            if (Utils.isAngleOutsideInterval(vx, vy, x1, y1, x2, y2, p.EPSILON)) {
                return true;
            }

        }

        return false;
    }

}

