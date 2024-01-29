package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import PUM.PUM;

public class PUMTest {

    /*  *
     * INVALID INPUT TESTS
     * Tests that evaluate function raises assertion error when given invalid parameter input.
     */
    
    @Test
    public void assertThatWrongValueInLCMThrowsException() {
        String[][] LCM = new String[15][15];
        boolean[] CMV = new boolean[15];

        for(int i = 0; i < LCM.length; i++) {
            for (int j = 0; j < LCM.length; j++) {
                LCM[i][j] = "ANDD";
            }
        }
        LCM[5][5] = "LOL";
        
        assertThrows(IllegalArgumentException.class, () -> {new PUM(LCM, CMV).calculatePUM();});
    } 

    @Test
    public void assertThatTooSmallCMVThrowsException() {
        String[][] LCM = new String[15][15];
        boolean[] CMV = new boolean[13];

        for(int i = 0; i < LCM.length; i++) {
            for (int j = 0; j < LCM.length; j++) {
                LCM[i][j] = "ANDD";
            }
        }
        
        assertThrows(AssertionError.class, () -> {new PUM(LCM, CMV).calculatePUM();});
    }

    @Test
    public void assertThatTooSmallLCMThrowsException() {
        String[][] LCM = new String[13][15];
        boolean[] CMV = new boolean[15];

        for(int i = 0; i < LCM.length; i++) {
            for (int j = 0; j < LCM.length; j++) {
                LCM[i][j] = "ANDD";
            }
        }
        
        assertThrows(AssertionError.class, () -> {new PUM(LCM, CMV).calculatePUM();});
    }

     /*
     * ------ FAILING TESTS ------
     * Tests that the function evaluates to false when supposed to
     */

    @Test
    public void assertThatAllFalseCMVOrrLCMReturnsAllFalsePUM() {

        boolean[] CMV = new boolean[15];
        Arrays.fill(CMV, Boolean.FALSE);
        
        String[][] LCM = new String[15][15];
        for(int i = 0; i < LCM.length; i++) {
            for (int j = 0; j < LCM.length; j++) {
                LCM[i][j] = "ORR";
            }
        }
        boolean[][] PUM = new PUM(LCM,CMV).calculatePUM();

        for (int i = 0; i < PUM.length; i++) {
            for (int j = 0; j < PUM.length; j++){
                assertFalse(PUM[i][j]);
            }
        }
    }   
    
     /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to true when supposed to
     */
    
    @Test
    public void assertThatAllTrueCMVAnddLCMReturnsAllTruePUM() {

        boolean[] CMV = new boolean[15];
        Arrays.fill(CMV, Boolean.TRUE);
        
        String[][] LCM = new String[15][15];
        for(int i = 0; i < LCM.length; i++) {
            for (int j = 0; j < LCM.length; j++) {
                LCM[i][j] = "ANDD";
            }
        }
        boolean[][] PUM = new PUM(LCM,CMV).calculatePUM();

        for (int i = 0; i < PUM.length; i++) {
            for (int j = 0; j < PUM.length; j++){
                assertTrue(PUM[i][j]);
            }
        }
    }

    @Test
    public void assertThatAllTrueCMVNOTUSEDLCMReturnsAllTruePUM() {

        boolean[] CMV = new boolean[15];
        Arrays.fill(CMV, Boolean.TRUE);
        
        String[][] LCM = new String[15][15];
        for(int i = 0; i < LCM.length; i++) {
            for (int j = 0; j < LCM.length; j++) {
                LCM[i][j] = "NOTUSED";
            }
        }
        boolean[][] PUM = new PUM(LCM,CMV).calculatePUM();

        for (int i = 0; i < PUM.length; i++) {
            for (int j = 0; j < PUM.length; j++){
                assertTrue(PUM[i][j]);
            }
        }
    }
}