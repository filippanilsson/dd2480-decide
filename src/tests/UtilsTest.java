package tests;
import LIC.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void assertArePointsCoincidentalReturnsRightAnswer() {
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 4.0;
        double y2 = 3.0;

        boolean excpectedAnswer = false;
        boolean answer = Utils.arePointsCoincident(x1, y1, x2, y2);
        assertEquals(excpectedAnswer, answer);

        x2 = 0.0;
        y2 = 0.0;

        excpectedAnswer = true;
        answer = Utils.arePointsCoincident(x1, y1, x2, y2);
        assertEquals(excpectedAnswer, answer);
    }

    @Test
    public void assertAreaReturnsRightAnswer() {
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 4.0;
        double y2 = 3.0;
        double x3 = 0.0;
        double y3 = 2.0;

        double excpectedAnswer = 4.0;
        double answer = Utils.area(x1, y1, x2, y2, x3, y3);
        assertEquals(excpectedAnswer, answer);

        x2 = -3.0;
        y2 = -4.0;
        x3 = 1.0;
        y2 = 3;

        excpectedAnswer = 4.5;
        answer = Utils.area(x1, y1, x2, y2, x3, y3);
        assertEquals(excpectedAnswer, answer);

        x2 = 0.0;
        y2 = 0.0;
        x3 = 0.0;
        y3 = 0.0;
        
        excpectedAnswer = 0.0;
        answer = Utils.dist(x1, y1, x2, y2);
        answer = Utils.area(x1, y1, x2, y2, x3, y3);
        assertEquals(excpectedAnswer, answer);
    }

    @Test
    public void assertDistReturnsRightAnswer() {
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 4.0;
        double y2 = 3.0;

        double excpectedAnswer = 5.0;
        double answer = Utils.dist(x1, y1, x2, y2);
        assertEquals(excpectedAnswer, answer);

        x2 = -3.0;
        y2 = -4.0;

        answer = Utils.dist(x1, y1, x2, y2);
        assertEquals(excpectedAnswer, answer);

        x2 = 0.0;
        y2 = 0.0;
        
        excpectedAnswer = 0.0;
        answer = Utils.dist(x1, y1, x2, y2);
        assertEquals(excpectedAnswer, answer);

    }

    @Test
    public void assertIsAngleOutsideIntervalReturnsRightAnswer() {
        double x1 = 3.0;
        double y1 = 1.0;
        double vx = 0.0;
        double vy = 0.0;
        double x2 = 1.0;
        double y2 = 3.0;
        double epsilon = 2.0;

        boolean excpectedAnswer = true;
        boolean answer = Utils.isAngleOutsideInterval(vx, vy, x1, y1, x2, y2, epsilon);
        assertEquals(excpectedAnswer, answer);

        epsilon = 2.5;

        excpectedAnswer = false;
        answer = Utils.isAngleOutsideInterval(vx, vy, x1, y1, x2, y2, epsilon);
        assertEquals(excpectedAnswer, answer);
    }

    @Test
    public void assertIsTriangleObtuseReturnsRIghtAnswer() {
        double a = 3.0;
        double b = 3.16;
        double c = 5.0;

        boolean excpectedAnswer = true;
        boolean answer = Utils.isTriangleObtuse(a, b, c);
        assertEquals(excpectedAnswer, answer);

        b = 4.0;

        excpectedAnswer = false;
        answer = Utils.isTriangleObtuse(a, b, c);
        assertEquals(excpectedAnswer, answer);
    }

    @Test
    public void assertMinEnclosingRadiusReturnsRightAnswer() {
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 3.0;
        double y2 = 0.0;
        double x3 = 0.0;
        double y3 = 4.0;

        double excpectedAnswer = 2.500;
        double answer = roundToThree(Utils.minEnclosingRadius(x1, y1, x2, y2, x3, y3));
        assertEquals(excpectedAnswer, answer);
        
        x2 = 4.0;
        y2 = 1.0;

        excpectedAnswer = 2.577;
        answer = roundToThree(Utils.minEnclosingRadius(x1, y1, x2, y2, x3, y3));
        assertEquals(excpectedAnswer, answer);
    }
    
    private double roundToThree(double x) {
        return (double) Math.round(x * 1000)/1000;
    }
}
