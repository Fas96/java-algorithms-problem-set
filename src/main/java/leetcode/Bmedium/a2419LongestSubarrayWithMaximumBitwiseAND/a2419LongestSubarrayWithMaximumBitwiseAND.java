package leetcode.Bmedium.a2419LongestSubarrayWithMaximumBitwiseAND;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class a2419LongestSubarrayWithMaximumBitwiseAND {
    @Test
    public void testlongestSubarray(){
        assertEquals(2,longestSubarray(new int[]{1,2,3,3,2,2}));
    }
    public int longestSubarray(int[] nums) {
        int getMax= Arrays.stream(nums).max().getAsInt();

        int ans=0;

        int mx=Integer.MIN_VALUE;

        for (int num : nums) {

            if(num==getMax)ans++;
            else{
                mx=Math.max(ans,mx);
                ans=0;
            }
        }

        return  Math.max(mx,ans);
    }
}
