package tests;

import FUV.FUV;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;


public class FUVTest {

    /**
     * INVALID INPUT TESTS
     * Tests that calculate function raises assertion error when given invalid input.
     */

    @Test
    public void assertThatTooSmallPUVRaisesError() {
        boolean[] PUV = new boolean[14];
        boolean[][] PUM = new boolean[15][15];
        assertThrows(AssertionError.class, () -> {(new FUV()).calculateFUV(PUV,PUM);});
    }

    @Test
    public void assertThatTooSmallPUMRaisesError() {
        boolean[] PUV = new boolean[15];
        boolean[][] PUM = new boolean[14][15];
        assertThrows(AssertionError.class, () -> {(new FUV()).calculateFUV(PUV,PUM);});
    }

    /*
     * ------ FAILING TESTS ------
     * Tests that the function evaluates to a vector of all falses when supposed to
     */
    @Test
    public void assertThatPUVAllTruePUMAllFalseReturnsAllFalse() {
        boolean[] PUV = new boolean[15];
        boolean[][] PUM = new boolean[15][15];
        for (int i = 0; i < 15; i++) {
            PUV[i] = true;
            for (int j = 0; j < 15; j++) {
                PUM[i][j] = false;
            }
        }
        boolean[] FUV = (new FUV()).calculateFUV(PUV,PUM);
        for (int i = 0; i < 15; i++) {
            assertFalse(FUV[i]);
        }
    }
    

    /*
     * ------ PASSING TESTS ------
     * Tests that the function evaluates to a vector of all trues when supposed to
     */

    @Test
    public void assertThatPUVAllFalseReturnsAllTrue() {
        boolean[] PUV = new boolean[15];
        boolean[][] PUM = new boolean[15][15];
        for (int i = 0; i < 15; i++) {
            PUV[i] = false;
            for (int j = 0; j < 15; j++) {
                PUM[i][j] = false;
            }
        }
        boolean[] FUV = (new FUV()).calculateFUV(PUV,PUM);
        for (int i = 0; i < 15; i++) {
            assertTrue(FUV[i]);
        }
    }
    
    @Test
    public void assertThatPUMRowAllTrueReturnsAllTrue() {
        boolean[] PUV = new boolean[15];
        boolean[][] PUM = new boolean[15][15];
        
        for (int i = 0; i < 15; i++) {
            PUV[i] = true;
            for (int j = 0; j < 15; j++) {
                PUM[i][j] = true;
            }
        }
        boolean[] FUV = (new FUV()).calculateFUV(PUV,PUM);
        for (int i = 0; i < 15; i++) {
            assertTrue(FUV[i]);
        }
    }
    
    
}
