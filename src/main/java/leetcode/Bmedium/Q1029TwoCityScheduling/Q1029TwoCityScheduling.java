package leetcode.Bmedium.Q1029TwoCityScheduling;

import java.util.Map;
import java.util.PriorityQueue;

public class Q1029TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int cost=0;
        for (int[] c : costs    ) {
            cost+= Math.min(c[0],c[1]);
        }
        return cost;
    }
}
