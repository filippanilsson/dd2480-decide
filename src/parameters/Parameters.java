package parameters;
/**
 * A class to collect all parameters given in a single object.
 * The LIC functions take the whole object and pick which fields to look at depending on the specification
 * of the LIC.
 */

public class Parameters {

    public final double LENGTH1;
    public final double RADIUS1;
    public final double EPSILON;
    public final double AREA1;
    
    public final int Q_PTS;
    public final int QUADS;
    public final double DIST;
    public final int N_PTS;
    public final int K_PTS;
    public final int A_PTS;
    public final int B_PTS;
    public final int C_PTS;
    public final int D_PTS;
    public final int E_PTS;
    public final int F_PTS;
    public final int G_PTS;
    
    public final double LENGTH2;
    public final double RADIUS2;
    public final double AREA2;


    // TODO: fill this with the parameters from the assignment description

    public Parameters(double LENGTH1, double RADIUS1, double EPSILON, double AREA1, int Q_PTS, int QUADS, double DIST, int N_PTS, int K_PTS, int A_PTS, int B_PTS, int C_PTS, int D_PTS, int E_PTS, int F_PTS, int G_PTS, double LENGTH2, double RADIUS2, double AREA2)
     {
        this.LENGTH1 = LENGTH1;
        this.RADIUS1 = RADIUS1;
        this.EPSILON = EPSILON;
        this.AREA1 = AREA1;
        this.Q_PTS = Q_PTS;
        this.QUADS = QUADS;
        this.DIST = DIST;
        this.N_PTS = N_PTS;
        this.K_PTS = K_PTS;
        this.A_PTS = A_PTS;
        this.B_PTS = B_PTS;
        this.C_PTS = C_PTS;
        this.D_PTS = D_PTS;
        this.E_PTS = E_PTS;
        this.F_PTS = F_PTS;
        this.G_PTS = G_PTS;
        this.LENGTH2 = LENGTH2;
        this.RADIUS2 = RADIUS2;
        this.AREA2 = AREA2;
    }
}
