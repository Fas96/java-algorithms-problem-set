package leetcode.Bmedium.a981TimeBasedKeyValueStore;

import java.util.HashMap;
import java.util.Map;

public class a981TimeBasedKeyValueStore {
    class TimeMap {
        HashMap<String, Map<String ,Integer>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key))map.put(key,new HashMap<>());
            map.get(key).put(value,timestamp);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key))return "";
            Map<String,Integer> m = map.get(key);
            String res = "";
            for(String s : m.keySet()){
                if(m.get(s)<=timestamp && m.get(s)>m.getOrDefault(res,0))res = s;
            }
            return res;
        }
    }
}
