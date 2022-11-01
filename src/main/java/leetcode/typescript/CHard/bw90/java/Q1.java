package leetcode.typescript.CHard.bw90.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    @Test
    public void test() {

    }
    public String oddString(String[] words) {
        String [] convert = new String [words.length];

        StringBuilder sb;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; ++i){
            sb = new StringBuilder();

            for (int j = 1; j < words[i].length(); ++j){
                int val1 = words[i].charAt(j) - 'a';
                int val2 = words[i].charAt(j - 1) - 'a';

                int diff = val2 - val1;
                sb.append(diff + ":");
            }

            String s = sb.toString();
            convert[i] = s;
            //System.out.println(s);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < words.length; ++i){
            if (map.get(convert[i]) == 1)
                return words[i];
        }

        return "";
    }
}
