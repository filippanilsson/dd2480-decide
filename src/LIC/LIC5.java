package LIC;

import parameters.Parameters;

/**
 * Evaluates LIC #5
 * There exists at least one set of two consecutive data points, 
 * (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)
 */
public class LIC5 implements LIC {

    /**
     * Evaluates LIC #5
     * @param p Parameters object that contains all constant values
     * @param NUMPOINTS the amount of points
     * @param POINTSX an array of the x-coordinates of all points
     * @param POINTSY an array of the y-coordinates of all points
     * @return a boolean stating whether the 5:th LIC is satisfied
     */
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {

        if (NUMPOINTS < 2) return false;

        for (int i = 0; i < NUMPOINTS-1; i++) {
            if (POINTSX[i+1] - POINTSX[i] < 0) return true;
        }
        return false;   
    }
}
