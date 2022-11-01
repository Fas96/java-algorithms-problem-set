package leetcode.typescript.CHard.bw90.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    @Test
    public void test() {

    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries){
            for (String word : dictionary){
                if (isEdit(query, word)){
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }

    private boolean isEdit(String query, String word){
        if (query.length() != word.length()) return false;

        int count = 0;

        for (int i = 0; i < query.length(); ++i){
            if (query.charAt(i) != word.charAt(i))
                ++count;
        }

        return count <= 2;
    }
}
