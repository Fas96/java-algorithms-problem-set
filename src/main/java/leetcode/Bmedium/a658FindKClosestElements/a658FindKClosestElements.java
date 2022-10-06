package leetcode.Bmedium.a658FindKClosestElements;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class a658FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[0]!=a[0] ? b[0] - a[0] : b[1] - a[1]);

        for (int a : arr) {
            pq.offer(new int[]{Math.abs(a-x), a});
            if(pq.size()>k)pq.poll();
        }

        List<Integer> res = pq.stream().map(e->e[1]).collect(Collectors.toList());
        Collections.sort(res);
       return res;
    }

    @Test
    public void findClosestElementsTest(){
        assertEquals(Arrays.asList(1,2,3,4),findClosestElements(new int[]{1,2,3,4,5},2,-10));
    }
}
