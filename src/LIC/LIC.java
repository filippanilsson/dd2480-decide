package LIC;
import parameters.Parameters;

/**
 * Interface for the LIC functions.
 */
public interface LIC {
    
    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY); 
}