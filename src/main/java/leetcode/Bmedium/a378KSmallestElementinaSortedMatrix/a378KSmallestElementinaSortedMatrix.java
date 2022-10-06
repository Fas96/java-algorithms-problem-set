package leetcode.Bmedium.a378KSmallestElementinaSortedMatrix;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class a378KSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int ans=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1-o2);
        int cnt=0;
        for (int []a:matrix) {
            for (int n : a) {
                cnt++;
                if(cnt==k)return n;
//                pq.add(n);

            }
        }
        while (k-->0){
            ans=pq.poll();
        }
        return ans;
    }
    public int kthSmallestA(int[][] matrix, int k) {

        List<Integer> A=new ArrayList<>();

        for (int []a:matrix) {
             A.addAll(Arrays.stream(a).boxed().collect(Collectors.toList()));
        }
        Collections.sort(A);
        return A.get(k);
    }
    @Test
    public void kthSmallestTest(){
        System.out.println(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }
}
