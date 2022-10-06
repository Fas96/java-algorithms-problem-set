package leetcode.Bmedium.a1770MaximumScorefromPerformingMultiplicationOperations;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class a1770MaximumScorefromPerformingMultiplicationOperations {
    public int maximumScoreTwoHeaps(int[] nums, int[] multipliers) {
        PriorityQueue<Integer> numMH = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        PriorityQueue<Integer> multipliersMH = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int n : nums) {
            numMH.add(n);
        }
        for (int n : multipliers) {
            multipliersMH.add(n);
        }
        int score = 0;
        while (!multipliersMH.isEmpty()) {
            int x = multipliersMH.poll();
            int y = numMH.poll();

            score += (x * y);
        }
        return score;
    }

    @Test
    public void maximumScoreTwoHeapsTest() {
        assertEquals(14, maximumScoreTwoHeaps(new int[]{3, 2, 1}, new int[]{1, 2, 3}));
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[1000][1000];
        return memo(nums, multipliers, 0, 0, nums.length - 1, dp);
    }

    private int memo(int[] nums, int[] multipliers, int L, int R, int N, int[][] dp) {
        if (L == multipliers.length)
            return 0;
        if (dp[R][L] != 0)
            return dp[R][L];
        int lf = nums[R] * multipliers[L] + memo(nums, multipliers, L + 1, R + 1, N, dp);
        int rg = nums[N] * multipliers[L] + memo(nums, multipliers, L + 1, R, N - 1, dp);
        dp[R][L] = Math.max(lf, rg);
        return dp[R][L];

    }
}
