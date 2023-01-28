package leetcode.Y2023.personal.bsearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2530MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        int ans= 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        while (k > 0 && !pq.isEmpty()){
            int cur = pq.poll();
            ans += cur;
            pq.add((cur+2)/3);
            k--;
        }

        return ans;

    }
}
