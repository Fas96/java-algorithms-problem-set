package leetcode.Eweekly.w318;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q2 {
    @Test
    public void testSol() {
        assertEquals(24, maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3));

    }



    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long sum = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if(isDistinct(nums, i, j)){
                    max = Math.max(max, sum);
                    sum -= nums[i];
                }

                i++;
                j++;
            }

        }


        return max;
    }

    private boolean isDistinct(int[] nums, int i, int j) {

        Set<Integer> set = new HashSet<>();
        for (int k = i; k <= j; k++) {
            if (set.contains(nums[k])) {
                return false;
            }
            set.add(nums[k]);
        }
        return true;
    }

}

