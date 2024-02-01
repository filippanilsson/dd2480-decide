package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #1
 * There exists at least one set of three consecutive data points that cannot all be contained within or on a circle of radius RADIUS1. (0 ≤ RADIUS1) 
*/ 

public class LIC1 implements LIC {

    /**
    * Evaluates LIC #1
    * @param p Parameters object that contains all constant values
    * @param NUMPOINTS the amount of points
    * @param POINTSX an array of the x-coordinates of all points
    * @param POINTSY an array of the y-coordinates of all points
    * @return a boolean stating whether the 1:st LIC is satisfied
    */
   public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {

        assert(NUMPOINTS >= 3);
        assert(0 <= p.RADIUS1);
        

        for (int i = 0; i < NUMPOINTS-2; i++){
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i+1];
            double y2 = POINTSY[i+1];
            double x3 = POINTSX[i+2];
            double y3 = POINTSY[i+2];

            double minEnclosingRadius = Utils.minEnclosingRadius(x1, y1, x2, y2, x3, y3);

            if (minEnclosingRadius > p.RADIUS1) return true;
        }
       return false;
   }
}

