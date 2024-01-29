package FUV;
/**
 * Calculates the Final Unlocking Vector from the Preliminary Unlocking Vector and Preliminary Unlocking Matrix
 * 
 * FUV[i] should be set to true if PUV[i] is false (indicating that the associated LIC should not hold back launch) or if all elements in PUM row i are true
 */

public class FUV {
    
    /**
     * Calculates the Final Unlocking Vector (FUV)
     * @param PUV Preliminary Unlocking Vector, a boolean array with 15 elements
     * @param PUM Preliminary Unlocking Matrix, a boolean 15x15 symmetric 2D-array
     * @return a boolean array representing the Final Unlocking Vector with 15 elements
    */
    public boolean[] calculateFUV(boolean[] PUV, boolean[][] PUM) {
        assert(PUV.length == 15);
        assert(PUM.length == 15);
        for (int i = 0; i < 15; i++) {
            assert(PUM[i].length == 15);
        }

        boolean[] FUV = new boolean[15];
        for (int i = 0; i < FUV.length; i++) {
            FUV[i] = true;
            if (PUV[i]) {
                for (int j = 0; j < PUM[i].length; j++) {
                    if ((i != j) && (!PUM[i][j])) FUV[i] = false;
                }
            }
        }
        return FUV;
    }

}
