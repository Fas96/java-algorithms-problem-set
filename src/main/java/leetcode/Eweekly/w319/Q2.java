package leetcode.Eweekly.w319;

import org.junit.Test;

public class Q2 {
    @Test
    public void testSol(){

    }
    //return the number of subarrays of nums where the least common multiple of the subarray's elements is k.
    public int subarrayLCM(int[] nums, int k) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            int lcm=nums[i];
            for(int j=i;j<nums.length;j++){
                lcm=lcm(nums[j],lcm);
                if(lcm==k){
                    result++;
                }
            }
        }
        return result;

    }

    private int lcm(int num, int lcm) {
        return num*lcm/gcd(num,lcm);
    }

    private int gcd(int num, int lcm) {
        if(num==0) return lcm;
        return gcd(lcm%num,num);
    }
}
