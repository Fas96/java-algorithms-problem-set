package leetcode.Bmedium.a347TopKFrequentElements;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class a347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        int[]res=new int[k];

        for (int n : nums) {hm.merge(n,1,Integer::sum);}
         AtomicInteger cnt = new AtomicInteger();
        List<Map.Entry<Integer, Integer>> entryList = hm.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toList());

        hm.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEach(e->{
           if(cnt.get() <k){
           res[cnt.getAndIncrement()]= (int) e.getKey();
           }
       });


        return res;
     }
     @Test
    public void  testtopKFrequent(){
         System.out.println(Arrays.toString(topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2)));
         int[] arrDesc = Arrays.stream(new int[]{3,2,3,1,2,4,5,5,6}).boxed()
                 .sorted().distinct()
                 .mapToInt(Integer::intValue)
                 .toArray();
         System.out.println(Arrays.toString(arrDesc));
         System.out.println(arrDesc[2]);
     }
}
