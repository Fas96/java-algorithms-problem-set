package leetcode.Y2023.weekly.w331;

import java.util.HashMap;
import java.util.Map;

public class Q6347CountVowelStringsInRanges {
    public int[] vowelStringsMAP(String[] words, int[][] queries) {
        int qs = queries.length;
        int[] res = new int[qs];
        int n = words.length;
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (word.length() > 0) {
                char first = word.charAt(0);
                char last = word.charAt(word.length() - 1);
                if (isVowel(first) && isVowel(last)) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }


        for (int i = 0; i < qs; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int counter = 0;
            for (int j = l; j <= r; j++) {
                counter += map.getOrDefault(j, 0);
            }
            res[i] = counter;
        }

        return res;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
            int qs = queries.length;
            int[] res = new int[qs];
            int n = words.length;
            int[] prefix = new int[n];
            for (int i = 0; i < n; i++) {
                String word = words[i];
                if (word.length() > 0) {
                    char first = word.charAt(0);
                    char last = word.charAt(word.length() - 1);
                    if (isVowel(first) && isVowel(last)) {
                        prefix[i] = 1;
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                prefix[i] += prefix[i - 1];
            }

            for (int i = 0; i < qs; i++) {
                int l = queries[i][0];
                int r = queries[i][1];
                if (l == 0) {
                    res[i] = prefix[r];
                } else {
                    res[i] = prefix[r] - prefix[l - 1];
                }
            }

            return res;
        }
        private static boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
//    public static boolean startsAndEndsWithVowel(String str) {
//        if (str.length() == 0) {
//            return false;
//        }
//        char first = str.charAt(0);
//        char last = str.charAt(str.length() - 1);
//        return (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' || first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U') &&
//                (last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u' || last == 'A' || last == 'E' || last == 'I' || last == 'O' || last == 'U');
//    }



}
