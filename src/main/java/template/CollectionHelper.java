package template;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

public class CollectionHelper {


  @Test
  public void givenArrayList_FindAverage(){
    Map<Object, Object> map = new HashMap<>();
    map.put("corgi",    1);
    map.put("pug",      2);
    map.put("shih tzu", 3);
    map.put("husky",    1);
    assertEquals(Arrays.asList("pug"),getKeysWithCertainValue(map,2));
  }

  private void printArray(int[] a){
    for (int i = 0; i <a.length; i++) {
      System.out.println(a[i]);
    }
  }
  public void arrayPermutations(int[] arr,int cid){
    if (cid== arr.length-1){
      printArray(arr);
      return;
    }
    for (int i = cid; i < arr.length; i++) {
     swapArr(arr,i,cid+1);
     arrayPermutations(arr,cid+1);
      swapArr(arr,i,cid+1);
    }
  }
  private void swapArr(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }

  List<List<Object>> processBatchSplitKTimes(List<Object> list,int batchSize) {
    return IntStream.range(0, list.size())
        .filter(i -> i % batchSize == 0)
        .mapToObj(i -> list.subList(i, Math.min(i + batchSize, list.size())))
        .collect(Collectors.toList());

  }
  boolean areMapsEqual(HashMap<String, String> m1, HashMap<String, String> m2) {
    if (m1.size() != m2.size()) { return false; }
    return m1.entrySet().stream()
        .allMatch(e -> e.getValue().equals(m2.get(e.getKey())));
  }
  boolean allSame(List<Object> lst,Object determiner){
    return lst.stream().allMatch(n -> n == determiner );
  }

  List<Object> flatten2DList(List<List<Object>> listOfLists){
    return   listOfLists.stream().collect(ArrayList::new, List::addAll, List::addAll);
  }
  List<Object> mapKeyAsList(Map<Object, Object> map){
    return new ArrayList<>(map.keySet());
  }
  List<Object> mapValuesAsList(Map<Object, Object> map){
    return new ArrayList<>(map.values());
  }


  List<Object> getKeysWithCertainValue(Map<Object, Object> map, Integer value) {
    return map
        .entrySet()
        .stream()
        .filter(e -> Objects.equals(e.getValue(), value))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  };
  List<Integer> combineTwoIntegerList(List<Integer> list1,List<Integer> list2){
    return Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
  }
  Object[] convertListToArray(List<Object> list){
//    return list.toArray(String::new);
    return list.toArray();
  }
  private String escape(String str) {
    List<String> specialChars = Arrays.asList(
        "\\","^","$","{","}","[","]","(",")",
        ".","*","+","?","|","<",">","-","&","%"
    );
    return Arrays
        .stream(str.split(""))
        .map(c -> {
          if (specialChars.contains(c)) {
            return "\\" + c;
          } else {
            return c;
          }
        })
        .collect(Collectors.joining());
  }
  public Set<Object> hMapToSet(Map<String, Object> map){
//  return   new HashSet<Object>(map.values() );
  return   new HashSet<Object>(map.keySet() );
  }



}
