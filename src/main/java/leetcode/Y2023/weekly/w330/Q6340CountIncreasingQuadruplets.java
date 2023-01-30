package leetcode.Y2023.weekly.w330;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*
*
* Given a 0-indexed integer array nums of size n containing all numbers from 1 to n, return the number of increasing quadruplets.

A quadruplet (i, j, k, l) is increasing if:

0 <= i < j < k < l < n, and
nums[i] < nums[k] < nums[j] < nums[l]
* */
public class Q6340CountIncreasingQuadruplets {
    public long countQuadruplets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]--;
        }
        long[][] dp = new long[nums.length][nums.length];
        int N = nums.length;
        int M = 1;
        while (M < N) {
            M <<= 1;
        }
        int[] tree = new int[M * 2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) continue;
                int l = M, r = nums[j] + M - 1;
                long sum = 0;
                while (l <= r) {
                    if (l % 2 == 1) {
                        sum += tree[l];
                        l >>= 1;
                        l++;
                    } else {
                        l >>= 1;
                    }
                    if (r % 2 == 0) {
                        sum += tree[r];
                        r >>= 1;
                        r--;
                    } else {
                        r >>= 1;
                    }
                }
                dp[i][j] = sum;
            }
            int n = nums[i] + M;
            while (n > 0) {
                tree[n]++;
                n >>= 1;
            }
        }
        tree = new int[M * 2];
        for (int j = nums.length - 1; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                if (nums[i] <= nums[j]) continue;
                int l = nums[i] + M + 1, r = M * 2 - 1;
                long sum = 0;
                while (l <= r) {
                    if (l % 2 == 1) {
                        sum += tree[l];
                        l >>= 1;
                        l++;
                    } else {
                        l >>= 1;
                    }
                    if (r % 2 == 0) {
                        sum += tree[r];
                        r >>= 1;
                        r--;
                    } else {
                        r >>= 1;
                    }
                }
                dp[i][j] *= sum;
            }
            int n = nums[j] + M;
            while (n > 0) {
                tree[n]++;
                n >>= 1;
            }
        }
        long res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                res += dp[i][j];
            }
        }
        return res;

    }

    @Test
    public void testcountQuadruplets() {
        int[] nums = {1,2,3,6};
        long res = countQuadruplets(nums);

        nums = new int[]{1,3,2,4,5};
        res = countQuadruplets(nums);
        assertEquals(2, res);
        //[1,2,3,4]
        nums = new int[]{1,2,3,4};
        res = countQuadruplets(nums);
        assertEquals(0, res);
    }
}
