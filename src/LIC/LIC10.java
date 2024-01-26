package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #10
 * There exists at least one set of three data points separated by exactly E_PTS and F_PTS consecutive intervening points, respectively, that are the vertices of a triangle with area greater than AREA1. The condition is not met when NUMPOINTS < 5.
 * 1 ≤ E_PTS, 1 ≤ F_PTS
 * E_PTS+F_PTS ≤ NUMPOINTS−3
*/ 
public class LIC10 implements LIC{
    /**
    * Evaluates LIC #10
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
        if(p.E_PTS < 1 || p.F_PTS < 1)
            return false;
        if(p.E_PTS + p.F_PTS > NUMPOINTS - 3)
            return false;
        
        for(int i = 0; i < NUMPOINTS - p.E_PTS - p.F_PTS - 2; ++i) {
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i + p.E_PTS + 1];
            double y2 = POINTSY[i + p.E_PTS + 1];
            double x3 = POINTSX[i + p.E_PTS + p.F_PTS + 2];
            double y3 = POINTSY[i + p.E_PTS + p.F_PTS + 2];

            //Check if the area satisfy the condition
            if(area(x1, y1, x2, y2, x3, y3) > p.AREA1) {
                return true;
            }
        }
        return false;
    }

    private double area(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))/2;
        return a;
    }
    
}
