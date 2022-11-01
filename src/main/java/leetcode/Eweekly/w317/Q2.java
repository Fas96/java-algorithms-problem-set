package leetcode.Eweekly.w317;

import org.junit.Test;

import java.util.*;

public class Q2 {
    @Test
    public void testW317Q2() {

    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        long max = 0;

        for (int i = 0; i < creators.length; ++i){
            map.put(creators[i], map.getOrDefault(creators[i], 0L) + views[i]);
            map2.put(creators[i], Math.max(map2.getOrDefault(creators[i], 0), views[i]));

            max = Math.max(max, map.get(creators[i]));
        }

        Map<String, String> res = new HashMap<>();

        for (String key : map.keySet()){
            if (map.get(key) == max){
                res.put(key, "zzzzzz");
            }
        }

        String s;

        for (int i = 0; i < creators.length; ++i){
            if (res.containsKey(creators[i]) && views[i] == map2.get(creators[i]) && ids[i].compareTo(res.get(creators[i])) <= 0){
                res.put(creators[i], ids[i]);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : res.keySet()){
            result.add(Arrays.asList(key, res.get(key)));
        }

        return result;
    }

}
