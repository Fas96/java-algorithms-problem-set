package leetcode.Chard.c1383MaximumPerformanceofaTeam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;


public class c1383MaximumPerformanceofaTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> swers = new ArrayList<>();
        for (int i = 0; i < n; i++)
            swers.add(new int[]{speed[i], efficiency[i]});
        swers.sort((a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> curTeam = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        long teamSpeed = 0;
        long maxPerformance = Long.MIN_VALUE;

        for (int[] cur : swers) {
            if (curTeam.size() == k) {
                int[] slowGuy = curTeam.poll();
                assert slowGuy != null;
                teamSpeed -= slowGuy[0];
            }
            curTeam.add(cur);
            teamSpeed += cur[0];

            long performanceWithNewGuy = teamSpeed * (long) cur[1];
            maxPerformance = Math.max(maxPerformance, performanceWithNewGuy);

        }
        return (int) (maxPerformance % (int) (1e9 + 7));
    }

    @Test
    public void maxPerformanceTest() {
        assertEquals(60, maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));
    }
}
