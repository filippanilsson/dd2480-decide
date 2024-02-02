package decide;

import parameters.Parameters;
import FUV.FUV;
import LIC.*;
import PUM.PUM;

/**
 * Makes the final decision on wheter to allow a launch or not. If the input parameters 
 * are invalid this will throw an exception. Returns it's answer in the form of
 * "YES" or "NO" in standard output.
 */
public class Decide {
    /**
     * Decides wheter to allow a launch or not. 
     * NOTE: Retruns it's answer in the form of "YES" or "NO" in standard output.
     * @param NUMPOINTS the amount of points
     * @param POINTSX an array of the x-coordinates of all points
     * @param POINTSY an array of the y-coordinates of all points
     * @param parameters Parameters object that contains all constant values
     * @param LCM the logical connection matrix
     * @param PUV Preliminary Unlocking Vector, a boolean array with 15 elements
     */
    public static void DECIDE(int NUMPOINTS, double[] POINTSX, double[] POINTSY,
        Parameters parameters, String[][] LCM, boolean[] PUV) {
        LIC[] lics = {
            new LIC0(),
            new LIC1(),
            new LIC2(),
            new LIC3(),
            new LIC4(),
            new LIC5(), 
            new LIC6(),
            new LIC7(),
            new LIC8(),
            new LIC9(),
            new LIC10(), 
            new LIC11(),
            new LIC12(),
            new LIC13(),
            new LIC14(), 
        };

        try {
            boolean[] cmv = new boolean[lics.length];
            for (int i = 0; i < lics.length; i++) {
                cmv[i] = lics[i].evaluate(parameters, NUMPOINTS, POINTSX, POINTSY);
            }
            boolean[][] pum = PUM.calculatePUM(LCM, cmv);
            boolean[] fuv = FUV.calculateFUV(PUV, pum);

            boolean launch = true;
            for (boolean b : fuv) {
                if (!b) {
                    launch = false;
                    break;
                }
            }

            if (launch) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (Exception e) {
            throw e;
        }


    }
}
