package leetcode.Y2023.weekly.bw98;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q6361MinimumScoreByChangingTwoElements {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        return Math.min(Math.min(nums[nums.length - 3] - nums[0], nums[nums.length - 2] - nums[1]), nums[nums.length - 1] - nums[2]);

    }

    @Test
    public void test(){
        System.out.println(minimizeSum(Ps.intArray("[[31,25,72,79,74,65]]")[0]));
    }
}
