package leetcode.Chard.c30SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class c30SubstringwithConcatenationofAllWords {


  public Object[] permutateArray(){
    return arrs.stream().map(e -> String.join("", e)).toArray();
  }
  @Test
  public  void  findSub(){
//
//    "wordgoodgoodgoodbestword"
//        ["word","good","best","good"]
//    System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
//    System.out.println(permute( new String[]{"bar","foo","the"}));
    String[] words= new String[]{"wod","good","best","good"};
    Map<String, Integer> countMap = new HashMap<>();
    for (String word : words) {
      countMap.merge(word, 1, Integer::sum);
    }
    countMap.entrySet().forEach(e-> System.out.println(e.getKey()+"|"+e.getValue()));
    int length = words[0].length() * words.length;
    System.out.println(length);
  }

  public List<Integer> findSubstring(String s, String[] words) {
    Set<Integer> res= new HashSet<>();
    List<List<String>> peList= permute(words);
    System.out.println(peList);

    for (int i = 0; i < peList.size(); i++) {
      String str=peList.get(i).stream().map(e -> String.join("", e)).collect(Collectors.joining());
      for (int j = 0; j < s.length(); j++) {
        if(s.substring(j).startsWith(str)){
          res.add(j);
        }
      }
    }
    return new ArrayList<>(res);

  }
  List<String[]> arrs= new ArrayList<>();
  private void printArray(String[] a){
    String[] innerarrs= new String[a.length];
    for (int i = 0; i <a.length; i++) {
     innerarrs[i]=a[i];
    }
    System.out.println(Arrays.toString(innerarrs));
    arrs.add(innerarrs);

  }
  public void arrayPermutations(String[] arr,int cid){
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
  private void swapArr(String[] arr,int i,int j){
    String temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }

  public List<List<String>> permute(String[] nums) {
    List<List<String>> results = new ArrayList<List<String>>();
    if (nums == null || nums.length == 0) {
      return results;
    }
    List<String> result = new ArrayList<>();
    dfs(nums, results, result);
    return results;
  }


  public void dfs(String[] nums, List<List<String>> results, List<String> result) {
    if (nums.length == result.size()) {
      List<String> temp = new ArrayList<>(result);
      results.add(temp);
    }
    for (int i=0; i<nums.length; i++) {
      if (!result.contains(nums[i])) {
        result.add(nums[i]);
        dfs(nums, results, result);
        result.remove(result.size() - 1);
      }
    }
  }

  @Test
  public  void permTest() {
    int[] arr = {1, 2, 2, 5};
    permutation(arr, new int[]{});
    r.forEach(e-> System.out.println(Arrays.toString(Arrays.stream(e).toArray())));
  }
  List<int[]> r=new ArrayList<>();

   void permutation(int[] arr, int[] prefix) {
    if (arr.length == 0) {
      r.add(prefix);
    }
    for (int i = 0; i < arr.length; i++) {
      int i2 = i;
      int[] pre = IntStream.concat(Arrays.stream(prefix), IntStream.of(arr[i])).toArray();
      int[] post = IntStream.range(0, arr.length).filter(i1 -> i1 != i2).map(v -> arr[v]).toArray();
      permutation(post, pre);
    }
  }
}
