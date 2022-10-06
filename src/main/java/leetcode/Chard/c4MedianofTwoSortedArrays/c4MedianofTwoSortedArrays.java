package leetcode.Chard.c4MedianofTwoSortedArrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class c4MedianofTwoSortedArrays {
    @Test
    public void test() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals ( 2.00000,findMedianSortedArrays(nums1, nums2));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2){
        double ans=0;
        int[] nums=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                nums[k++]=nums1[i++];
            }else{
                nums[k++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            nums[k++]=nums1[i++];
        }
        while(j<nums2.length){
            nums[k++]=nums2[j++];
        }
        if(nums.length%2==0){
            ans=(nums[nums.length/2-1]+nums[nums.length/2])/2.0;
        }else{
            ans=nums[nums.length/2];
        }
        return ans;
    }


}
