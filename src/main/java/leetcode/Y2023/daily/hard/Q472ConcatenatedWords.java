package leetcode.Y2023.daily.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q472ConcatenatedWords {
    class Trie {
        Trie[] array;
        boolean isWord;
        public Trie() {
            array = new Trie[26];
            isWord = false;
        }
    }
    public boolean search(Trie root, String word, int begin, int num) {
        Trie current = root;
        for(int i = begin; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if( current.array[index] == null )
                return false;
            current = current.array[index];
            if( current.isWord && search(root, word, i + 1, num + 1) )
                return true;
        }
        return num >= 1 && current.isWord;
    }
    public void trieBuilder(Trie root, String word) {
        Trie current = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if( current.array[index] == null )
                current.array[index] = new Trie();
            current = current.array[index];
        }
        current.isWord = true;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for(String word : words)
            trieBuilder(root, word);
        List<String> res = new ArrayList<>();
        for(String word : words)
            if( search(root, word, 0, 0) )
                res.add(word);
        return res;
    }





    @Test
    public void test() {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
       List<String> res= findAllConcatenatedWordsInADict(words);
       //["catsdogcats","dogcatsdog","ratcatdogcat"]
        System.out.println(res);
    }
}
