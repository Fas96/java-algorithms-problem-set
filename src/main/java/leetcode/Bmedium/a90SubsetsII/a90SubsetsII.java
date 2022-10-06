package leetcode.Bmedium.a90SubsetsII;

import org.junit.Test;

import java.util.*;

public class a90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            int e = nums[i];
            int start = i > 0 && nums[i] == nums[i - 1] ? end : 0;
            end = res.size();
            for(int j = start; j < end; j++) {
                List<Integer> sub = new ArrayList<>(res.get(j));
                sub.add(e);
                res.add(sub);
            }
        }

        return res;
    }
    private void powerSet(String str, int index, String curr)
    {
        int n = str.length();

        if (index == n) {
            return;
        }
        System.out.println(curr);
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            powerSet(str, i, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    private  void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {

        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }

        if (i >= n)
            return;
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);
        combinationUtil(arr, n, r, index, data, i + 1);
    }


    private void printCombination(int arr[], int n, int r) {
        int data[] = new int[r];
        combinationUtil(arr, n, r, 0, data, 0);
    }
    @Test
    public void combinationPrint(){
        int arr[] = { 10, 20, 30, 40, 50 };
        int r = 2;
        int n = arr.length;
        printCombination(arr, n, r);
    }
    @Test
    public void powerSetTest(){
        powerSet("abc",-1,"");
    }
}
