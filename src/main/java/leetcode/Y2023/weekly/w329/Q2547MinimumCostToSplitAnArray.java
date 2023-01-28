package leetcode.Y2023.weekly.w329;

import java.util.Arrays;

public class Q2547MinimumCostToSplitAnArray {
    private int[] dp;
    private int[] count;

    public int minCost(int[] nums, int k) {
        int n = nums.length;
        dp = new int[n];
        count = new int[1010];
        Arrays.fill(dp , - 1);
        for (int i = 0;i < n;i ++) {
            Arrays.fill(count , 0);
            int single = 0;
            for (int j = i;j >= 0;j --) {
                count[nums[j]] ++;
                if (count[nums[j]] == 1) {
                    single ++;
                } else if (count[nums[j]] == 2) {
                    single --;
                }
                int trim = i - j + 1 - single + k;
                if (j == 0) {
                    if (trim < dp[i] || dp[i] < 0) {
                        dp[i] = trim;
                    }
                } else {
                    if (dp[j - 1] >= 0) {
                        trim += dp[j - 1];
                        if (trim < dp[i] || dp[i] < 0) {
                            dp[i] = trim;
                        }
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
