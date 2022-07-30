package leetcode.Bmedium.a916WordSubsets;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class a916WordSubsets {

//["amazon","apple","facebook","google","leetcode"]
//    ["lo","eo"]
  @Test
  public void givenStringList_WithSubsetTestListReturn(){
    assertEquals(Arrays.asList("leetcode"),wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"lee","eo"}));
  }

  public List<String> wordSubsets(String[] words1, String[] words2) {
   List<String> res= new ArrayList<>();
   int[] freq= new int[26];
   int[] frWord= new int[26];
    for (String word : words2) {
      frWord=wordFrequency(word);
      for (int i = 0; i <26; ++i) {
        freq[i] = Math.max(freq[i], frWord[i]);
      }
    }
    System.out.println(Arrays.toString(freq));


    for (int i = 0; i < words1.length; i++) {
      int[] wordFrequency = wordFrequency(words1[i]);
      int counter=0;
      for (int j = 0; j <26; ++j) {
        if (wordFrequency[j]<freq[j])break;
        counter+=1;
      }
      if(counter==26)res.add(words1[i]);
    }
    return res;
  }
  int[] wordFrequency(String word) {
    int[] freq = new int[26];
    for (char c : word.toCharArray()) freq[c - 'a']++;
    return freq;
  }
}
