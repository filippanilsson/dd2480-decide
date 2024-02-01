import parameters.Parameters;
import decide.Decide;

public class Main {
    public static void main(String[] args) {
        Parameters p = new Parameters();

        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        boolean[] PUV = new boolean[15];
        String[][] LCM = new String[15][15];

        Decide.DECIDE(NUMPOINTS, POINTSX, POINTSY, p, LCM, PUV);
    }
}