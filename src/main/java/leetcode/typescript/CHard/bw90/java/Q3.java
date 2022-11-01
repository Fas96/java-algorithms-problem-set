package leetcode.typescript.CHard.bw90.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q3 {
    @Test
    public void test() {

    }
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : nums){
            map.put(num % space, map.getOrDefault(num % space, 0) + 1);
            max = Math.max(max, map.get(num % space));
        }

        int res = Integer.MAX_VALUE;

        for (int num : nums){
            if (map.get(num % space) == max)
                res = Math.min(res, num);
        }

        return res;
    }
}
