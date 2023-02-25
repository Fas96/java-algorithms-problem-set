package leetcode.Y2023.personal.prefix;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q974SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int res=0;
        Map<Integer, Integer> sumPrefixMap = new HashMap<>();
        sumPrefixMap.put(0, 1);
        System.out.println(Arrays.toString(prefix));

        for (int i = 1; i <=n; i++) {
            int IsDivisible = (prefix[i] % k + k) % k;
            System.out.println("IsDivisible = " + IsDivisible);
            if (sumPrefixMap.containsKey(IsDivisible)) {
                res += sumPrefixMap.get(IsDivisible);
            }
            sumPrefixMap.merge(IsDivisible, 1, Integer::sum);
        }
        return res;
    }

    @Test
    public void testsubarraySum() {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        int res = subarraysDivByK(nums, k);
        assertEquals(7, res);
        nums = new int[]{1,2,3};
        k = 3;
//        res = subarraysDivByK(nums, k);
//        assertEquals(2, res);
    }
}
