package leetcode.Y2023.weekly.w331;

import java.util.*;

public class Q6345RearrangingFruits {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int v : basket1){
            map.merge(v, 1, Integer::sum);
        }
        for(int v : basket2){
            map.merge(v, 1, Integer::sum);
        }
        for(int v : map.values()){
            if(v % 2 != 0)return -1;
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        for(int v : basket1){
            map1.merge(v, 1, Integer::sum);
        }
        List<Integer> c = new ArrayList<>();
        for(int v : map.keySet()){
            int cha = Math.abs(map.get(v)/2 - map1.getOrDefault(v, 0));
            for(int i = 0;i < cha;i++){
                c.add(v);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int v : map.keySet()){
            min = Math.min(min, v);
        }

        Collections.sort(c);
        long ans = 0;
        for(int i = 0;i < c.size()/2;i++){
            ans += Math.min(min*2L, c.get(i));
        }

        return ans;
    }
}
