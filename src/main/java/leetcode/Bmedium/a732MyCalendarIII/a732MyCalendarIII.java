package leetcode.Bmedium.a732MyCalendarIII;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Index out of bounds for length 1000000000
* ["MyCalendarThree","book"]
[[],[0,1000000000]]
* */
public class a732MyCalendarIII {
    class MyCalendarThree {
        Map<Integer,Integer> map;


        public MyCalendarThree() {
            map = new TreeMap<>();
        }


        public int book(int start, int end) {
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
            int res = 0;
            int count = 0;
            for(int i : map.keySet()){
                count += map.get(i);
                res = Math.max(res,count);
            }
            return res;

        }
    }

    @Test
    public void testMyCalendarThree(){

    }


}
