package leetcode.Chard.c336PalindromePairs;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class c336PalindromePairs {
    int MAX_CHAR = 26;
    public List<List<Integer>> palindromePairsTLE(String[] words) {
        List<List<Integer>> ans= new ArrayList<>();


        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words.length;j++)
            {
                if(i!=j)
                {
                    if(isPalinDrome(words[i]+words[j]))
                        ans.add(Arrays.asList(i,j) );
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if(words.length < 2) return Collections.emptyList();

        Map<String, Integer> wIdxM = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            wIdxM.put(words[i], i);

        }

        for(int i = 0; i < words.length; i++) {
            String reverse = reverse(words[i]);
            int n = reverse.length();
            for(int cut = 0; cut <= n; cut++) {
                String left = reverse.substring(0, cut);
                String right = reverse.substring(cut, n);

                if(wIdxM.containsKey(left) && wIdxM.get(left) != i && isPalinDrome(right)) {
                    ans.add(Arrays.asList(wIdxM.get(left), i));
                }
                if(cut != 0 && wIdxM.containsKey(right) && wIdxM.get(right) != i && isPalinDrome(left)) {
                    ans.add(Arrays.asList(i, wIdxM.get(right)));
                }
            }
        }

        return ans;
    }


    boolean checkPal(String a) {
        int i=0,j=a.length()-1;
        while(i<=j)
        {
            if(a.charAt(i)!=a.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public boolean isPa(String s, int i, int j) {
        for (; i < j; ++i, --j)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    public boolean check(String a, String b) {
        for (int i = 0, j = a.length() - 1; i < j; ++i, --j)
            if (a.charAt(i) != b.charAt(j))
                return isPa(a, i, j) || isPa(b, i, j);
        System.out.println(a+"|"+b);
        return true;
    }
    public boolean isPalinDrome(String text) {
        String temp  = text.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2).noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }
    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    @Test
    public void checkPalindromeFormation() {

        System.out.println( palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }
}
