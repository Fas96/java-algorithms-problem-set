package leetcode.Eweekly.W309;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class A {
  @Test
  public void testSol(){
    System.out.println(checkDistances("abaccb",new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
  }
  public boolean checkDistances(String s, int[] distance) {
    char[]arChars=s.toCharArray();
    Map<Character,Integer> hm =new HashMap<>();
    for (int i = 0; i < distance.length; i++) {
      hm.put((char)(97+i),distance[i]);
    }

    Set<Character> cDr=new LinkedHashSet<>();
    for (char c:arChars) {
      cDr.add(c);
    }

    for (Character c:cDr) {
      char cur= (char) c;
      if((s.lastIndexOf(cur)-s.indexOf(cur))-1!=hm.get(c))return false;

  }
    return true;
  }
}
