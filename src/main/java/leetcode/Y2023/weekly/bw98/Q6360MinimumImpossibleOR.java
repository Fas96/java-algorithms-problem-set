package leetcode.Y2023.weekly.bw98;

import java.util.HashSet;

public class Q6360MinimumImpossibleOR {
    public int minImpossibleOR(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1;; i *= 2) {
            if (!set.contains(i)) {
                return i;
            }
        }
    }
}
