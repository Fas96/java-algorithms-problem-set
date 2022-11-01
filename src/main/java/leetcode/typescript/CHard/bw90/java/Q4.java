package leetcode.typescript.CHard.bw90.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

import static java.util.Arrays.binarySearch;
import static org.junit.Assert.assertEquals;

public class Q4 {
    @Test
    public void test() {
        assertEquals(new int[]{9,6,6,-1,-1},secondGreaterElement(new int[]{2,4,0,9,6}));
//        assertEquals(new int[]{-1,-1},secondGreaterElement(new int[]{3,3}));

    }
        public int[] secondGreaterElement(int[] nums) {
            int [] res = new int [nums.length];

            Arrays.fill(res, -1);

            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < nums.length; ++i){

                while (!queue.isEmpty() && nums[queue.peek()] < nums[i]){
                    res[queue.poll()] = nums[i];
                }

                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                    queue.add(stack.pop());
                }

                stack.push(i);
            }

            return res;
        }



}
