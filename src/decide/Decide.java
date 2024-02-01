package decide;

import parameters.Parameters;
import FUV.FUV;
import LIC.*;
import PUM.PUM;

public class Decide {
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
