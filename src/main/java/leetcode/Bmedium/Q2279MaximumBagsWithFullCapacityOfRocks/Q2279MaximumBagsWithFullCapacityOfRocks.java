package leetcode.Bmedium.Q2279MaximumBagsWithFullCapacityOfRocks;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q2279MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] deficiency = new int[n];
        int totalDeficiency = 0;
        for (int i = 0; i < n; i++) {
            deficiency[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(deficiency);

        while (totalDeficiency < n && additionalRocks >= deficiency[totalDeficiency]) {
            additionalRocks -= deficiency[totalDeficiency];
            totalDeficiency++;
        }
        return totalDeficiency;
    }
    @Test
    public void test(){
        assertEquals(3, maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
    }
}
