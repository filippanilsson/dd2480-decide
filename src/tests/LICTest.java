package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import parameters.*;
import LIC.*;

public class LICTest {

    Parameters p = new Parameters();

    @Test 
    public void assertsThatLIC0ReturnsTrueWithValidCriteria() {
        p.LENGTH1 = 0.5;
        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        LIC0 lic0 = new LIC0();
        assertTrue(lic0.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatLIC0ReturnsFalseWithInvalidCriteria() {
        p.LENGTH1 = 2.0;
        int NUMPOINTS = 8;
        double[] POINTSX = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        double[] POINTSY = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
        LIC0 lic0 = new LIC0();
        assertFalse(lic0.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatLIC1ReturnsTrueWithValidCriteria(){
        p.RADIUS1 = 1.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 2.0, 3.0};
        double[] POINTSY = {1.0, 2.0, 3.0};
        LIC1 lic1 = new LIC1();
        assertTrue(lic1.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }

    @Test
    public void assertThatLIC1ReturnsFalseWithInvalidCriteria() {
        p.RADIUS1 = 3.0;
        int NUMPOINTS = 3;
        double[] POINTSX = {1.0, 2.0, 3.0};
        double[] POINTSY = {1.0, 2.0, 3.0};
        LIC1 lic1 = new LIC1();
        assertFalse(lic1.evaluate(p, NUMPOINTS, POINTSX, POINTSY));
    }
}