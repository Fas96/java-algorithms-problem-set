package leetcode.Y2023.daily.dmedium;

import java.util.HashMap;

public class Q540SingleElementInASortedArray {

    public int singleNonDuplicateBSEARCH(int[] nums) {
        int low = 0;
        int high = nums.length-2;
        while (low<=high) {
            int mid = low+(high-low)/2;
            if (nums[mid]==nums[mid^1]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return nums[low];
    }
    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num :nums)map.merge(num, 1, Integer::sum);

        return map.entrySet().stream().filter(e->e.getValue()==1).findFirst().get().getKey();
    }

}
