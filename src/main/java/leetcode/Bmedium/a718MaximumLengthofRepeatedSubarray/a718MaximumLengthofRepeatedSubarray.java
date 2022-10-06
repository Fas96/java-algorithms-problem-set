package leetcode.Bmedium.a718MaximumLengthofRepeatedSubarray;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class a718MaximumLengthofRepeatedSubarray {
    public int findLengthDP(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int M = nums2.length;
        int mx=0;
        int[][]dp=new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(nums1[i]==nums2[j]) {
                    dp[i+1][j+1] =1 + dp[i][j];
                    mx = Math.max(mx, dp[i+1][j+1]);
                }

            }
            System.out.println(Arrays.deepToString(dp));
        }

        return mx;
    }

    //
//[5,14,53,80,48]
//        [50,47,3,80,83][1,2,3,2,1]
//[3,2,1,4,7]
    @Test
    public void testFindLength(){
       assertEquals(3,findLengthDP(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
    public int findLengthHH(int[] nums1, int[] nums2) {
        int ans=0;
        Set<List<Integer>> num1Set= new LinkedHashSet<>();
        Set<List<Integer>> num2Set= new LinkedHashSet<>();
        List<Integer> n1=Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> n2=Arrays.stream(nums2).boxed().collect(Collectors.toList());

        for (int i = 0; i < n1.size(); i++) {
            num1Set.add(n1.subList(0,i));
            for (int j = i; j < n1.size(); j++) {
                num1Set.add(n1.subList(i,j));
            }
        }
        for (int i = 0; i < n2.size(); i++) {
            num2Set.add(n2.subList(0,i));
            for (int j = i; j < n1.size(); j++) {
                num2Set.add(n2.subList(i,j));
            }
        }

        for (List<Integer> num : num1Set) {
            if(num2Set.contains(num) && contigious(num,n2) && contigious(num,n1)){
                System.out.println(num);
                ans=Math.max(ans,num.size());
            }
        }
        System.out.println();
        return ans;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int ans=0;
        Set<List<Integer>> num1Set= new LinkedHashSet<>();
        Set<List<Integer>> num2Set= new LinkedHashSet<>();
        List<Integer> n1=Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> n2=Arrays.stream(nums2).boxed().collect(Collectors.toList());


        findSubsets(num1Set,   Arrays.stream(nums1).boxed().collect(Collectors.toList()), new ArrayList<>(), 0);
        findSubsets(num2Set,   Arrays.stream(nums2).boxed().collect(Collectors.toList()), new ArrayList<>(), 0);

        for (List<Integer> num : num1Set) {
            if(num2Set.contains(num) && contigious(num,n2) && contigious(num,n1)){
                System.out.println(num);
                ans=Math.max(ans,num.size());
            }
        }
        return ans;
    }

    private boolean contigious(List<Integer> num, List<Integer> n2) {
        return Collections.indexOfSubList(n2 , num)!=-1;
    }

    private void findSubsets(Set<List<Integer>> subset, List<Integer> nums, ArrayList<Integer> output, int index) {
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
         output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }


}
