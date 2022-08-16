package leetcode.Eweekly.w305;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import org.junit.Test;

public class q3 {

  @Test
  public  void sol_test(){
    assertEquals(false,validPartition(new int[]{4,4,4,5,6}));
  }

  static int countIncreasing(int [] arr)
  {
    int cnt = 0;
    for (int i=0; i<arr.length-1; i++) {
        if ((arr[i+1] - arr[i])==1){
          cnt+=1;
        }else{
          cnt=0;
        }
    }
    return cnt+1;
  }
  @Test
  public void arraysTest(){
    int[] a= new int[]{3};
    ArrayList<String> ss= new ArrayList<>(Arrays.asList("34","2"));
//    System.out.println(ss.removeIf(Predicate.isEqual("2")));
//    System.out.println(ss.removeIf(Predicate.isEqual("2")));
    ss.replaceAll(x -> x +"23");
    ss.trimToSize();
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    list= list.stream().map(e->e*2).collect(Collectors.toList());
    System.out.println(list);
    System.out.println(list);

  }
int maxRepeated(int[] arr){

  Map<Integer,Integer> histogram = new HashMap<>();
  for (int x : arr) {
    if (!histogram.containsKey(x)) histogram.put(x,1);
    else histogram.put(x,histogram.get(x) + 1);
  }
  int max = 0;
  for (int x : histogram.values().toArray(new Integer[0])) max = Math.max(max, x);
  return max;
}
  public boolean validPartition(int[] A) {
    List<Boolean> a= new ArrayList<>();
    int cnt=0;
    for (int i = 1; i < A.length + 1; i++) {
      for (int j = 0; j < A.length - i + 1; j++) {
        int[] concatWithArrayCopy = Arrays.copyOfRange(A, j, i + j);
        cnt++;

        if ((maxRepeated(concatWithArrayCopy) >= 2||countIncreasing(concatWithArrayCopy) >= 3)){
          System.out.println(Arrays.toString(concatWithArrayCopy));
          a.add(true);
        }

      }
    }

    boolean res=cnt==a.size();
    return res;
  }


   int[] concatWithArrayCopy(int[] array1, int[] array2) {
    int[] result = Arrays.copyOf(array1, array1.length + array2.length);
    System.arraycopy(array2, 0, result, array1.length, array2.length);
    return result;
  }

}
