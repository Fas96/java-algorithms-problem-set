package leetcode.Chard.c668KthSmallestNumberinMultiplicationTable;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class c668KthSmallestNumberinMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int ans=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                pq.offer(i*j);
            }
        }
        while (k-->0){
            ans=pq.poll();
        }


        return ans;
    }
    @Test
    public void findKthNumberTest(){
        System.out.println(findKthNumber(2,3,6));
    }
}
