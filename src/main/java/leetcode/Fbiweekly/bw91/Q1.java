package leetcode.Fbiweekly.bw91;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q1 {
    @Test
    public void testSol(){

    }
    public int distinctAverages(int[] nums) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        Set<Double> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            maxHeap.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            int min=minHeap.poll();
            int max=maxHeap.poll();
            set.add((min+max)/2.0);
        }

        return set.size();

    }
}
