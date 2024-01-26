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
        if(p.C_PTS < 1 || p.D_PTS < 1)
            return false;
        if(p.C_PTS + p.D_PTS > NUMPOINTS - 3)
            return false;
        
        for(int i = 0; i < NUMPOINTS - p.C_PTS - p.D_PTS - 2; ++i) {
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i + p.C_PTS + 1];
            double y2 = POINTSY[i + p.C_PTS + 1];
            double x3 = POINTSX[i + p.C_PTS + p.D_PTS + 2];
            double y3 = POINTSY[i + p.C_PTS + p.D_PTS + 2];

            // Check if the set of three points is always the vertex of the angle
            if (!arePointsCoincident(x1, y1, x2, y2) && !arePointsCoincident(x2, y2, x3, y3) && !arePointsCoincident(x1, y1, x3, y3)) {
                double angle1 = angle(x1, y1, x2, y2, x3, y3);
                double angle2 = angle(x2, y2, x1, y1, x3, y3); 
                double angle3 = angle(x3, y3, x1, y1, x2, y2);
    
                double epsilon1 = Math.PI - p.EPSILON;
                double epsilon2 = Math.PI + p.EPSILON;
    
                // Check if any of the angles satisfy the condition
                if (angle1 < epsilon1 || angle1 > epsilon2 ||
                    angle2 < epsilon1 || angle2 > epsilon2 ||
                    angle3 < epsilon1 || angle3 > epsilon2) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean arePointsCoincident(double x1, double y1, double x2, double y2) {
        return x1 == x2 && y1 == y2;
    }

    private double dist(double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1, 2));
        return dist;
    }

    private double angle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double dist12 = dist(x1, y1, x2, y2);
        double dist13 = dist(x1, y1, x3, y3);
        double dist23 = dist(x2, y2, x3, y3);

        double cosAngle = (Math.pow(dist12, 2) + Math.pow(dist13, 2) - Math.pow(dist23, 2)) / (2 * dist12 * dist13);

        // Make sure the value is within the valid range for acos
        cosAngle = Math.max(-1, Math.min(1, cosAngle));

        double angle = Math.acos(cosAngle);
        return angle;
    }
}

