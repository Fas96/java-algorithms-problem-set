package leetcode.Aeasy.a645SetMismatch;

import java.util.Map;
import java.util.TreeMap;

public class a645SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] result = findErrorNums(nums);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] findErrorNums(int[] nums) {
         int[] res= new int[2];
        Map<Integer,Integer> mp= new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.merge(nums[i],1,Integer::sum);
        }
        for (int i = 1; i < nums.length; i++) {
            if(mp.get(i)==null && mp.get(i)==2){
                res[0]=i;
            }else if(mp.get(i)==null&&mp.get(i)==0){
                res[1]=i;
            }

        }
        return res;
    }
}
