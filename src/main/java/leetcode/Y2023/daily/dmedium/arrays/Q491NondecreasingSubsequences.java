package leetcode.Y2023.daily.dmedium.arrays;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class Q491NondecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()>1) res.add(new LinkedList<Integer>(list));
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            if(used.contains(nums[i])) continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> te=   findSubsequences(new int[]{4,6,7,7});
        System.out.println(te);
        //4,4,3,2,1
        te=   findSubsequences(new int[]{4,4,3,2,1});
        System.out.println(te);
    }
}
