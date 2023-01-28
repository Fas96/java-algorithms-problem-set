package leetcode.Y2023.daily.dmedium.arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q974SubarraySumsDivisibleByK {
    public int subarraysDivByKMap(int[] nums, int k) {
        int totalCount = 0, sum = 0,n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum += nums[i];

            int mod = sum % k;

//            if(mod < 0)mod += k;

            if(map.containsKey(mod)){
                totalCount += map.get(mod);
                map.merge(mod, 1, Integer::sum);
            } else {
                map.put(mod, 1);
            }
        }
        return totalCount;
    }
    //TLE
    public int subarraysDivByK(int[] nums, int k) {


        int count=0;
        int n=nums.length;

        for (int i = 0; i < n; i++) {
            int localSum=0;
            int j=i;

            while (j < n) {
                localSum+=nums[j];
                if(localSum%k==0) count++;
                j++;
            }

        }

        return count;
    }

    @Test
    public void test() {
        int res = subarraysDivByKMap(new int[]{4,5,0,-2,-3,1}, 5);
        System.out.println(res);
        //nums = [5], k = 9
        //res = 0
        res = subarraysDivByKMap(new int[]{5}, 9);
        System.out.println(res);
    }
}
