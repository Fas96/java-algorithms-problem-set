package leetcode.Y2023.daily.dmedium;

public class Q2554MaximumNumberOfIntegersToChooseFromARangeI {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] isBanned = new boolean[20001];
        for (int b : banned) isBanned[b] = true;
        int res = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isBanned[i]) continue;
            sum += i;
            if (sum > maxSum) break;
            res++;
        }
        return res;

    }
}
