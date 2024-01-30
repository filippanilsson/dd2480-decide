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

        assert(0 <= p.RADIUS1);

        for (int i = 0; i < NUMPOINTS-2; i++){
            double x1 = POINTSX[i];
            double y1 = POINTSY[i];
            double x2 = POINTSX[i+1];
            double y2 = POINTSY[i+1];
            double x3 = POINTSX[i+2];
            double y3 = POINTSY[i+2];
            double dist1 = dist(x1, y1, x2, y2);
            double dist2 = dist(x2, y2, x3, y3);
            double dist3 = dist(x1, y1, x3, y3);

            double minEnclosingRadius;
            if (isTriangleObtuse(dist1, dist2, dist3)) minEnclosingRadius = Math.max(dist1,Math.max(dist2,dist3))/2;
            else minEnclosingRadius = (dist1*dist2*dist3)/Math.sqrt((dist1+dist2+dist3)*(dist1+dist2-dist3)*(dist1-dist2+dist3)*(-dist1+dist2+dist3));
            if (minEnclosingRadius > p.RADIUS1) return true;
        }
       return false;
   }

   private double dist(double x1, double y1, double x2, double y2) {
       double dist = Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1, 2));
       return dist;
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

