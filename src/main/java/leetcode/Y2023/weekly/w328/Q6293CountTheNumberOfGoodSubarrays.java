package leetcode.Y2023.weekly.w328;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;



/*
* Given an integer array nums and an integer k, return the number of good subarrays of nums.

A subarray arr is good if it there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].

A subarray is a contiguous non-empty sequence of elements within an array.
* */

public class Q6293CountTheNumberOfGoodSubarrays {
    public long countGood(int[] nums, int k) {

        long res = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (int n : nums){  list.add(n);end.add(n); }

        if (list.stream().distinct().count() ==1)res++;

      for (int i = 0; i <list.size() ; i++) {
            if(list!=end) {
                Map<Integer, List<Integer>> map2 = end.stream().collect(Collectors.groupingBy(sd -> sd));
                long local = map2.values().stream().filter(c -> c.size() > 1).count();

                Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(zz -> zz));
                long uniquePairs = map.values().stream().filter(c -> c.size() > 1).count();
                if(Math.max(uniquePairs,local)>=k)res++;

            }else{


                Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(zz -> zz));
                long uniquePairs = map.values().stream().filter(c -> c.size() > 1).count();
                if(uniquePairs>=k)res++;

            }
            if (list.size() > 0) {
                list.remove(0);
            }
            if (end.size() > 0) {
                end.remove(end.size() - 1);
            }
        }
        return res;
    }




    @Test
    public void testcountGood() {

//        int[] nums = new int[]{1,1,1,1,1};
//        int k = 10;
//        long res = countGood(nums, k);
//        Assert.assertEquals(1, res);

        int[] nums1 = new int[]{3,1,4,3,2,2,4};
        int k1 = 2;
        long res1 = countGood(nums1, k1);
        Assert.assertEquals(4, res1);

//        int[] nums2 = new int[]{2,3,3,3,3,1,3,1,3,2};
//        int k2 = 19;
//        long res2 = countGood(nums2, k2);
//        Assert.assertEquals(0, res2);
//
//
//
//        int[] nums3 = new int[]{2,1,3,1,2,2,3,3,2,2,1,1,1,3,1};
//        int k3 = 11;
//        long res3 = countGood(nums3, k3);
//        Assert.assertEquals(21, res3);
    }
}
