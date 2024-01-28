package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #3
 * There exists at least one set of three consecutive data points that are the vertices of a triangle
 * with area greater than AREA1. (0 ≤ AREA1)
 */

public class LIC3 implements LIC {

    /**
    * Evaluates LIC #3
    * @param p Parameters object that contains all constant values
    * @param NUMPOINTS the amount of points
    * @param POINTSX an array of the x-coordinates of all points
    * @param POINTSY an array of the y-coordinates of all points
    * @return a boolean stating whether the 3:rd LIC is satisfied
    */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY){

        assert(0 <= p.AREA1);
        
        if (NUMPOINTS < 3) {
            return false;
        }

        for(int i=0; i < NUMPOINTS-2; i++){
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i+1];
            double y2 = POINTSY[i+1];
            double x3 = POINTSX[i+2];
            double y3 = POINTSY[i+2];
        
            double area = area(x1, x2, x3, y1, y2, y3);
            
            if (area > p.AREA1) {
                return true;
            }
        }
        return false;
    }

    /**
    * Calculates the area of a triangle using the shoe lace formula
    * @param x1 x-coordinate of point 1
    * @param x2 x-coordinate of point 2
    * @param x3 x-coordinate of point 3
    * @param y1 y-coordinate of point 1
    * @param y2 y-coordinate of point 2
    * @param y3 y-coordinate of point 3
    * @return the area as a double
    */
    private double area(double x1, double x2, double x3, double y1, double y2, double y3){
        double area = Math.abs((x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2);
        return area;
    }
    
}
