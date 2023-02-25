package leetcode.Y2023.weekly.w331;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q6348TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> holder = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a:gifts) holder.offer(a);
         int count=0;
         long res=0;

         while (count<k){
             int take= holder.poll();
             holder.offer((int) Math.floor(Math.sqrt(take)));
             count++;
         }

         while (!holder.isEmpty())res+=holder.poll();

         return res;

    }

    @Test
    public void testpickGifts(){
        int []ara={25,64,9,4,100};
        System.out.println(pickGifts(ara,4));

    }
}
