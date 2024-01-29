package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #8
 * 
 * There exists at least one set of three data points separated by exactly A PTS and B PTS
consecutive intervening points, respectively, that cannot be contained within or on a circle of
radius RADIUS1. The condition is not met when NUMPOINTS < 5.
1 ≤ A PTS, 1 ≤ B PTS
A PTS + B PTS ≤ (NUMPOINTS − 3)
 */
public class LIC8 implements LIC {

    /**
     * Evaluates LIC #8
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the number of planar points
     * @param POINTSX an array of the x-coordinates of the planar points
     * @param POINTSY an array of the y-coordinates of the planar points
     * @return a boolean indicating whether LIC 8 is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        if (NUMPOINTS < 5) return false;
        assert(1 <= p.A_PTS);
        assert(1 <= p.B_PTS);
        assert(p.A_PTS+p.B_PTS <= NUMPOINTS-3);
        assert(p.RADIUS1 >= 0);
        for (int i = 0; i < NUMPOINTS-p.A_PTS-p.B_PTS-2; i++) {
            double a = Math.sqrt(Math.pow(POINTSX[i+p.A_PTS+1]-POINTSX[i],2)+Math.pow(POINTSY[i+p.A_PTS+1]-POINTSY[i],2));
            double b = Math.sqrt(Math.pow(POINTSX[i+p.A_PTS+p.B_PTS+2]-POINTSX[i],2)+Math.pow(POINTSY[i+p.A_PTS+p.B_PTS+2]-POINTSY[i],2));
            double c = Math.sqrt(Math.pow(POINTSX[i+p.A_PTS+p.B_PTS+2]-POINTSX[i+p.A_PTS+1],2)+Math.pow(POINTSY[i+p.A_PTS+p.B_PTS+2]-POINTSY[i+p.A_PTS+1],2));
            double minEnclosingRadius;
            if (isTriangleObtuse(a, b, c)) minEnclosingRadius = Math.max(a,Math.max(b,c))/2;
            else minEnclosingRadius = (a*b*c)/Math.sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c));
            if (minEnclosingRadius > p.RADIUS1) return true;
        }
        return false;
    }

    /**
     * Checks if a triangle is obtuse
     * @param a side length 1 of the triangle
     * @param b side length 2 of the triangle
     * @param c side length 3 of the triangle
     * @return a boolean indicating whether side lengths a,b,c form an obtuse triangle
     */
    private boolean isTriangleObtuse(double a, double b, double c) {
        return (2*Math.pow(Math.max(a,Math.max(b,c)), 2) > Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2));
    }

}