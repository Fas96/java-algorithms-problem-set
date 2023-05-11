package sedgewick.code;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;

public class RandomSeq {
    @Test
    public void testRandomSeq(){
        int N=5;
        double lo= 100.0;
        double hi=200.0;

        for (int i = 0; i < N; i++) {
            double x= StdRandom.uniform(lo,hi);
            StdOut.printf("%.2f\n",x);
        }
    }
}
