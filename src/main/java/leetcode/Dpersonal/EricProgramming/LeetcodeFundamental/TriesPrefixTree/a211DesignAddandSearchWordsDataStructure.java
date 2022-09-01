package leetcode.Dpersonal.EricProgramming.LeetcodeFundamental.TriesPrefixTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import jdk.jfr.internal.LogLevel;
import sun.net.www.http.HttpClient;

public class a211DesignAddandSearchWordsDataStructure {

 private class WordDictionary {

    private final Map<Integer, Set<String>> table;

    public WordDictionary() {this.table = new HashMap<>();}

    public void addWord(String word) {
      int n = word.length();
      this.table.computeIfAbsent(n, f -> new HashSet<>()).add(word);
    }

    public boolean search(String word) {
      int n = word.length();
      if (!table.containsKey(n)) {
        return false;
      }
      for (String w : table.get(n)) {
        int i = 0;
        while (i < n && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
          i++;
        }
        if (i == n) {
          return true;
        }
      }
      return false;
    }



  }

}
