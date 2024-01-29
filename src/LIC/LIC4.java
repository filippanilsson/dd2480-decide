package LIC;
import parameters.Parameters;

/**
 * Evaluates LIC #4
 * There exists at least one set of Q_PTS consecutive data points that lie in more than QUADS quadrants. 
 * Where there is ambiguity as to which quadrant contains a given point, priority of decision will be by quadrant number, 
 * i.e., I, II, III, IV. For example, the data point (0,0) is in quadrant I, the point (-1,0) is in quadrant II, the point (0,-1) 
 * is in quadrant III, the point (0,1) is in quadrant I and the point (1,0) is in quadrant I.
 * (2 ≤ Q PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)
 */
public class LIC4 implements LIC{

    public boolean evaluate(Parameters p, int NUMPOINTS, double[] POINTSX, double[] POINTSY) {
        assert(2 <= p.Q_PTS && p.Q_PTS <= NUMPOINTS);
        assert(1 <= p.QUADS && p.QUADS <= 3);

        for (int i = 0; i < NUMPOINTS-p.Q_PTS+1; i++) {
            int quadCount = 0;
            boolean [] visitedQuad = {false, false, false, false};
            System.out.println("we in loop " + i);
            for(int j = i; j < i+p.Q_PTS; j++) {
                System.out.println("double time  " + j);
                System.err.println(POINTSX[j] + " " + POINTSY[j]);
                if(POINTSX[j] >= 0 && POINTSY[j] >= 0) {
                   if (visitedQuad[0] == false){
                       quadCount++;
                    } 
                   visitedQuad[0] = true;
                }
                else if(POINTSX[j] < 0 && POINTSY[j] >= 0) {
                    if (visitedQuad[1] == false){
                        quadCount++;
                    } 
                    visitedQuad[1] = true;
                }
                else if (POINTSX[j] <= 0 && POINTSY[j] < 0) {
                    if (visitedQuad[2] == false){
                        quadCount++;
                    } 
                    visitedQuad[2] = true;
                }
                else if (POINTSX[j] > 0 && POINTSY[j] < 0){
                    if (visitedQuad[3] == false){
                        quadCount++;
                    } 
                    visitedQuad[3] = true;
                }
            }
            if(quadCount > p.QUADS) return true;
        }
        
        return false;
    }   
}
