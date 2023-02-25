package leetcode.Y2023.daily.deasy;

import java.util.ArrayList;
import java.util.List;

public class Q1470ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ansList.add(nums[i]);
            ansList.add(nums[i+n]);
        }
        return ansList.stream().mapToInt(i->i).toArray();

    }
}
