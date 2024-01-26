package LIC;
import parameters.Parameters;

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

            // Measure distances of lines AB and BC
            double dist1 = dist(x1, y1, x2, y2); 
            double dist2 = dist(x2, y2, x3, y3);

            double angle = Math.atan(dist1/dist2);
            if (angle < (Math.PI - p.EPSILON) || angle > (Math.PI + p.EPSILON)) {
                return true;
            }
        }
        return false;
    }

    private double dist(double x1, double y1, double x2, double y2) {
       double dist = Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1, 2));
       return dist;
   }
}
