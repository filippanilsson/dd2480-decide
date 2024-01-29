package PUM;

/**
 * Calculates the Preliminary Unlocking Matrix (PUM), where every element corresponds to 
 * an element of the LCM. If the logical connection dictated by the LCM element gives the value "true"
 * the corresponding PUM element is set to "true".
 */
public class PUM {

    private String [][] LCM;
    private boolean [] CMV;

    /**
     * Constructor for the PUM class
     * @param LCM the Logical Connector Matrix
     * @param CMV the Condition Met Vector
     */
    public PUM(String [][] LCM, boolean [] CMV) {
        this.LCM = LCM;
        this.CMV = CMV;
    }
    
    /**
     * Calculates the PUM 
     * @param
     * @return A 15x15 boolean matrix
     */
    public boolean [][] calculatePUM(){
        assert(CMV.length == 15);
        assert(LCM.length == 15);
        boolean [][] PUM = new boolean[15][15];

        for (int i = 0; i < LCM.length; i++){
            for (int j = 0; j < LCM.length; j++){
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