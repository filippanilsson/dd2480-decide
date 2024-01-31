import FUV.FUV;
import LIC.*;
import PUM.PUM;
import parameters.Parameters;

public class Main {
    public static void main(String[] args) {
        Parameters p = new Parameters();

        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        boolean[] PUV = new boolean[15];
        String[][] LCM = new String[15][15];

        DECIDE(NUMPOINTS, POINTSX, POINTSY, p, LCM, PUV);
    }
    
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
    }
}