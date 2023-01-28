package leetcode.Y2023.weekly.w328;

import org.junit.Assert;
import org.junit.Test;

public class Q6291DifferenceBetweenElementSumAndDigitSumOfAnArray {
    public int differenceOfSum(int[] nums) {
        long total = 0;
        long digitsTotal = 0;
        for (int n:nums){
            total += n;
            digitsTotal += digitsSum(n);
        }
        return Math.abs((int)(total - digitsTotal));


    }
    private int digitsSum(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }



    @Test
    public void test() {
        int[] nums = new int[]{1,15,6,3};
        int res = differenceOfSum(nums);
        Assert.assertEquals(9, res);

        int res2 = differenceOfSum(new int[]{1,2,3,4});
        Assert.assertEquals(0, res2);
    }
}
