package leetcode.Y2023.daily.dmedium;

import java.util.HashMap;
import java.util.Map;

public class Q567PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            s1Map.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i <= m-n; i++) {
            String sub = s2.substring(i, i+n);
            for (int j = 0; j < n; j++) {
                s2Map.merge(sub.charAt(j), 1, Integer::sum);
            }
            if(s1Map.equals(s2Map)) return true;
            s2Map.clear();
        }
        return false;

    }
}
