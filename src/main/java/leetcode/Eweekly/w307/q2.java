package leetcode.Eweekly.w307;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class q2 {


  @Test
  public  void sol_test(){
    assertEquals( "",largestPalindromic( "00009"));
  }


  public String largestPalindromic(String num) {
    Map<String,Integer> m=new HashMap<>();
    for (int i = 0; i < num.length(); i++) {
      m.merge(String.valueOf(num.charAt(i)),1,Integer::sum);
    }
    Map<String, Integer> collectOnes = m.entrySet().stream().filter(x -> x.getValue() == 1).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    Map<String, Integer> countGreater = m.entrySet().stream().filter(x -> x.getValue() > 1).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    NavigableMap<String,Integer> map  = new TreeMap<>(collectOnes);
    countGreater.put(map.lastEntry().getKey(),map.lastEntry().getValue());

    Map<String, Integer> result2 = new LinkedHashMap<>();

    countGreater.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.comparing(e->e%2==0)))
        .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
    System.out.println(result2);
    return  "";
  }

}
