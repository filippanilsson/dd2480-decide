package PUM;

/**
 * Calculates the Preliminary Unlocking Matrix (PUM), where every element corresponds to 
 * an element of the LCM. If the logical connection dictated by the LCM element gives the value "true"
 * the corresponding PUM element is set to "true".
 */
public class PUM {

    /**
     * Calculates the Preliminary Unlocking Matrix (PUM)
     * @param LCM the logical connection matrix
     * @param CMV the conditions met matrix
     * @return A 15x15 boolean matrix representing the PUM
     */
    public boolean [][] calculatePUM(String [][] LCM, boolean [] CMV){
        assert(CMV.length == 15);
        assert(LCM.length == 15);
        boolean [][] PUM = new boolean[15][15];

        for (int i = 0; i < LCM.length; i++){
            for (int j = 0; j < LCM[i].length; j++){
                switch(LCM[i][j]) {
                    case "ANDD": 
                        PUM[i][j] = CMV[i] && CMV[j];
                        break;
                    case "ORR":
                        PUM[i][j] = CMV[i] || CMV[j];
                        break;
                    case "NOTUSED":
                        PUM[i][j] = true;
                        break;
                    default: 
                        throw new IllegalArgumentException("LCM can not have any other value than ANDD, ORR, or NOTUSED!");
                }
            }
        }
        return PUM;
    } 
}