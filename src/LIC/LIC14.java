package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #14
 * There exists at least one set of three data points, separated by exactly E_PTS and F_PTS consecutive intervening points, respectively, that are the vertices of a triangle with area greater than AREA1. In addition, there exist three data points (which can be the same or different from the three data points just mentioned) separated by exactly E_PTS and F_PTS consecutive intervening points, respectively, that are the vertices of a triangle with area less than AREA2. Both parts must be true for the LIC to be true. 
 * The condition is not met when NUMPOINTS < 5. 
 * 0 ≤ AREA2 
*/ 
public class LIC14 implements LIC {

    /**
    * Evaluates LIC #14
    * @param p Parameters object that contains all constant values
    * @param NUMPOINTS the amount of points
    * @param POINTSX an array of the x-coordinates of all points
    * @param POINTSY an array of the y-coordinates of all points
    * @return a boolean stating whether the 9:st LIC is satisfied
    */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        assert(0 <= p.AREA1);
        assert(0 <= p.AREA2);
        assert(1 <= p.E_PTS);
        assert(1 <= p.F_PTS);
        assert(p.E_PTS+p.F_PTS <= NUMPOINTS-3);

        boolean existsAreaGreaterThanArea1 = false;
        boolean existsAreaLessThanArea2 = false;
        for(int i = 0; i < NUMPOINTS - p.E_PTS - p.F_PTS - 2 &&
            !(existsAreaGreaterThanArea1 && existsAreaLessThanArea2); i++) {
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i + p.E_PTS + 1];
            double y2 = POINTSY[i + p.E_PTS + 1];
            double x3 = POINTSX[i + p.E_PTS + p.F_PTS + 2];
            double y3 = POINTSY[i + p.E_PTS + p.F_PTS + 2];

            double curr_area = area(x1, y1, x2, y2, x3, y3);
            if(curr_area > p.AREA1) {
                existsAreaGreaterThanArea1 = true;
            }
            if(curr_area < p.AREA2) {
                existsAreaLessThanArea2 = true;
            }
        }
        return existsAreaGreaterThanArea1 && existsAreaLessThanArea2;
    }

    private double area(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))/2;
        return a;
    }
}
