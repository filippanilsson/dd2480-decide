package parameters;
/**
 * A class to collect all parameters given in a single object.
 * The LIC functions take the whole object and pick which fields to look at depending on the specification
 * of the LIC.
 */

public class Parameters {
    public double LENGTH1;
    public double RADIUS1;
    public double EPSILON;
    public double AREA1;
    
    public int Q_PTS;
    public int QUADS;
    public double DIST;
    public int N_PTS;
    public int K_PTS;
    public int A_PTS;
    public int B_PTS;
    public int C_PTS;
    public int D_PTS;
    public int E_PTS;
    public int F_PTS;
    public int G_PTS;
    
    public double LENGTH2;
    public double RADIUS2;
    public double AREA2;

    public Parameters(double LENGTH1, double RADIUS1, double EPSILON, double AREA1, int Q_PTS, int QUADS, double DIST, int N_PTS, int K_PTS,
        int A_PTS, int B_PTS, int C_PTS, int D_PTS, int E_PTS, int F_PTS, int G_PTS, double LENGTH2, double RADIUS2, double AREA2) {
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

    public Parameters() {
        this.LENGTH1 = 0.0;
        this.RADIUS1 = 0.0;
        this.EPSILON = 0.0;
        this.AREA1 = 0.0;
        
        this.Q_PTS = 0;
        this.QUADS = 0;
        this.DIST = 0.0;
        this.N_PTS = 0;
        this.K_PTS = 0;
        this.A_PTS = 0;
        this.B_PTS = 0;
        this.C_PTS = 0;
        this.D_PTS = 0;
        this.E_PTS = 0;
        this.F_PTS = 0;
        this.G_PTS = 0;
        
        this.LENGTH2 = 0.0;
        this.RADIUS2 = 0.0;
        this.AREA2 = 0.0;
    }
}
