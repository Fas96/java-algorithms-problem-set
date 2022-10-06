package leetcode.Bmedium.a985SumofEvenNumbersAfterQueries;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class a985SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int N=nums.length;
        int[] result= new int[N];
        if(N == 0)
            return new int[0];
        int sum = 0;

        for(int i = 0; i < N; i++) {
            if(nums[i] % 2 == 0) {
                sum += nums[i];
            }
        }
        for(int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            int x = (val + nums[index]);
            sum -= (nums[index] % 2 == 0) ? nums[index] : 0;
            sum += (x % 2 == 0) ? x : 0;
            nums[index] = x;
            result [i] = sum;
        }
//        return result;

//        for (int i = 0; i < N; i++) {
//            int[] quer= queries[i];
//            nums[quer[1]]=nums[quer[1]]+quer[0];
//            sum -= (nums[quer[1]] % 2 == 0) ? nums[quer[1]] : 0;
//            sum += (nums[quer[1]] % 2 == 0) ? nums[quer[1]] : 0;
//            result[i]=sum;
//        }


        return result;
    }
    @Test
    public void testEvenQueries(){
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1}, new int[][]{{4, 0}})));
    }
}
