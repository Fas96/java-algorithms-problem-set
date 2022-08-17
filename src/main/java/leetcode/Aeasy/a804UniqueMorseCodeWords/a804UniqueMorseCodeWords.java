package leetcode.Aeasy.a804UniqueMorseCodeWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class a804UniqueMorseCodeWords {
  @Test
  public void uniqueMorseRepresentationsTest(){
    System.out.println(uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
  }
  public int uniqueMorseRepresentations(String[] words) {
    String[] patterns= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    HashMap<Character,String> lettersTransformations= new HashMap<>();
    List<String> getSet= new ArrayList<>();
    for (int i = 0; i < patterns.length; i++) {
      lettersTransformations.put((char)(97+i),patterns[i]);
    }

    for (String word : words) {
      StringBuilder wordFormedPattern = new StringBuilder();
      for (int j = 0; j < word.length(); j++) {
        wordFormedPattern.append(lettersTransformations.get(word.charAt(j)));
      }
      getSet.add(String.valueOf(wordFormedPattern));
    }
    return new HashSet<>(getSet).size();
  }
}
