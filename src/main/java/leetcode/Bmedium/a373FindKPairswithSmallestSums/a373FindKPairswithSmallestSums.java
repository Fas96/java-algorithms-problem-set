package leetcode.Bmedium.a373FindKPairswithSmallestSums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class a373FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));



        for (int i = 0; i < nums1.length && i < k; i++) {
            List<Integer> list = Arrays.asList(nums1[i], nums2[0], 0);
            pq.offer(list);
        }
        System.out.println(pq);

        while (k--> 0 && !pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            res.add(Arrays.asList(cur.get(0), cur.get(1)));
            if(cur.get(2) == nums2.length-1) continue;
            pq.offer(Arrays.asList(cur.get(0), nums2[cur.get(2) + 1], cur.get(2) + 1));
        }

        return res;
    }
    @Test
    public void kSmallestPairsTest(){
        System.out.println(kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));
    }
}
