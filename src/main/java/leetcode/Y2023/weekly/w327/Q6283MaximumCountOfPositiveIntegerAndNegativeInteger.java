package leetcode.Y2023.weekly.w327;

public class Q6283MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int maxCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        for (int n :nums) {
            if (n > 0) {
                positiveCount++;
                negativeCount = 0;
            } else if (n < 0) {
                negativeCount++;
                positiveCount = 0;
            } else {
                positiveCount = 0;
                negativeCount = 0;
            }
            maxCount = Math.max(maxCount, Math.max(positiveCount, negativeCount));

        }
        return maxCount;


    }
}
