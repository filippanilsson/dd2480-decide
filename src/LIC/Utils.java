package LIC;

public final class Utils {
    private Utils() {
        throw new AssertionError("Utility class shouldn't be instantiated");
    }
    
    /**
     * Calculates the distance between two data points.
     * @param x1 x-coordinate of point 1
     * @param y1 y-coordinate of point 1
     * @param x2 x-coordinate of point 2
     * @param y2 y-coordinate of point 2
     * @return The Euclidean distance between two points in a two-dimensional plane
     */
    public static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1, 2));
    }

   /**
     * Checks if a triangle is obtuse
     * @param a side length 1 of the triangle
     * @param b side length 2 of the triangle
     * @param c side length 3 of the triangle
     * @return a boolean indicating whether side lengths a,b,c form an obtuse triangle
     */
    public static boolean isTriangleObtuse(double a, double b, double c) {
        return (2*Math.pow(Math.max(a,Math.max(b,c)), 2) > Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2));
    }

    /**
     * Checks if the angle created by the given points is outside an interval PI-epsilon and PI+epsilon
     * @param vx x-coordinate of the vertex
     * @param vy y-coordinate of the vertex
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @param epsilon the value deciding the interval around PI
     * @return a boolean indicating whether the angle is outside the interval
     */
    public static boolean isAngleOutsideInterval(double vx, double vy,
        double x1, double y1, double x2, double y2, double epsilon) {
        if (arePointsCoincident(x1, y1, vx, vy) || arePointsCoincident(vx, vy, x2, y2)) {
            return false;
        }

        double angle = angle(x1, y1, vx, vy, x2, y2);

        double lowerBound = Math.PI - epsilon;
        double higherBound = Math.PI + epsilon;    

        if (angle < lowerBound || angle > higherBound) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the given points are coincident
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @return a boolean indicating whether the points are coincident
     */
    public static boolean arePointsCoincident(double x1, double y1, double x2, double y2) {
        return x1 == x2 && y1 == y2;
    }

    /**
     * Calculates the angle between two points given a vertex
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param vx x-coordinate of the vertex
     * @param vy y-coordinate of the vertex
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @return the angle as a double
     */
    private static double angle(double x1, double y1, double vx, double vy, double x2, double y2) {
        double a = dist(vx, vy, x2, y2);
        double b = dist(x1, y1, vx, vy);
        double c = dist(x1, y1, x2, y2);

        double cosAngle = (a*a + b*b - c*c) / (2 * a * b);
        // Make sure the value is within the valid range for acos
        cosAngle = Math.max(-1, Math.min(1, cosAngle));

        double angle = Math.acos(cosAngle);
        return angle;
    }

    /**
     * Calculates the area of a triangle using the shoe lace formula
     * @param x1 x-coordinate of point 1
     * @param y1 y-coordinate of point 1
     * @param x2 x-coordinate of point 2
     * @param y2 y-coordinate of point 2
     * @param x3 x-coordinate of point 3
     * @param y3 y-coordinate of point 3
     * @return the area as a double
     */
    public static double area(double x1, double y1, double x2, double y2, double x3, double y3){
        double area = Math.abs((x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2);
        return area;
    }

    /**
     * Calculates the minimum radius neccessary to enclose the points
     * @param x1 x-coordinate of point 1
     * @param y1 y-coordinate of point 1
     * @param x2 x-coordinate of point 2
     * @param y2 y-coordinate of point 2
     * @param x3 x-coordinate of point 3
     * @param y3 y-coordinate of point 3
     * @return the minimum radius as a double
     */
    public static double minEnclosingRadius(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = Utils.dist(x1, y1, x2, y2);
        double b = Utils.dist(x2, y2, x3, y3);
        double c = Utils.dist(x1, y1, x3, y3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        double minEnclosingRadius;
        if (Utils.isTriangleObtuse(a, b, c)) {
            minEnclosingRadius = Math.max(a,Math.max(b,c))/2;
        } else { 
            double s = (a+b+c)/2;
            minEnclosingRadius = (a*b*c)/(4*Math.sqrt(s*(s-a)*(s-b)*(s-c)));
            // minEnclosingRadius = (a*b*c)/Math.sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c));
        }
        
        System.out.println(minEnclosingRadius);
        return minEnclosingRadius;
    }
}