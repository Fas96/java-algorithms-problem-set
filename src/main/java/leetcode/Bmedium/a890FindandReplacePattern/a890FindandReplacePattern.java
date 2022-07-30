package leetcode.Bmedium.a890FindandReplacePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a890FindandReplacePattern {

  //cs
  public List<String> findAndReplacePattern(String[] words, String pattern) {

    List<String> answer = new ArrayList<>();
    for (String s : words) {
      if (patternMatchHelper(s, pattern)) {
        answer.add(s);
      }
    }
    return answer;


  }

  //cs
  public boolean patternMatchHelper(String s, String p) {
    //If the lengths are not same return false.
    if (p.length() != s.length()) {
      return false;
    }
    // Map to hold  pattern to word character mapping
    HashMap<Character, Character> map = new HashMap<>();
    // Reverse Map
    HashMap<Character, Character> reverseMap = new HashMap<>();
    int i = 0;
    while (i < p.length()) {
      if (!map.containsKey(p.charAt(i))) {
        map.put(p.charAt(i), s.charAt(i));
      }
      if (!reverseMap.containsKey(s.charAt(i))) {
        reverseMap.put(s.charAt(i), p.charAt(i));
      }
      if (map.get(p.charAt(i)) != s.charAt(i)) {
        return false;
      }
      if (reverseMap.get(s.charAt(i)) != p.charAt(i)) {
        return false;
      }

      i++;

    }
    return true;
  }
}
