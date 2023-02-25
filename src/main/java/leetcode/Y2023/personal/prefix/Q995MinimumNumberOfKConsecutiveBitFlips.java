package leetcode.Y2023.personal.prefix;

import java.util.Arrays;

public class Q995MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] ==1)?0:1;
        }
        for (int i = 1; i <=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(nums));

        return 0;
    }
}
