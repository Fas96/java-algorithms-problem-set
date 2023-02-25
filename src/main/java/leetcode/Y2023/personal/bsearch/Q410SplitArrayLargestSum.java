package leetcode.Y2023.personal.bsearch;

public class Q410SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int n: nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (checkIfCanSplit(nums, k, mid)) high = mid;
            else low = mid + 1;

        }
        return low;
    }

    private boolean checkIfCanSplit(int[] nums, int m, int mid) {
        int sum = 0, count = 1;
        for (int n: nums) {
            sum += n;
            if (sum > mid) {
                sum = n;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}
