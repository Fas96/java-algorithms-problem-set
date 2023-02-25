package leetcode.Y2023.personal.prefix;



public class Q53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int res=nums[0];
        int minPrefix = nums[0];
        for (int i = 1; i <=n; i++) {
            res = Math.max(res, prefix[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }
        return res;
    }
}
