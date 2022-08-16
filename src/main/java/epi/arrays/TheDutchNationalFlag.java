package epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class TheDutchNationalFlag {
  @Test
  void givenArrayList_TestSWAP(){
//
  }
  enum Color { RED, WHITE, BLUE }
  //time O(n^2)
  //space O(1)
  public static void dutchFlagPartition(int pivotlndex, List<Color> A){
    Color pivot=A.get(pivotlndex);

    //First pass: group elements smaller than pivot
    for (int i = 0; i < A.size(); i++) {
      //smaller elements
      for (int j = i+1; j < A.size(); j++) {
        if(A.get(j).ordinal()<pivot.ordinal()){
          Collections.swap(A,i,j);
          break;
        }

      }
    }

    //Second Pass: group elements larger than pivot.
    for (int i = A.size()-1; i >=0 && A.get(i).ordinal()>=pivot.ordinal(); --i) {
      //Look for a larger element.Stop when we reach an element less
      //than pivot,since first pass moved them to the start of A.
      for (int j = i-1; j >=0 && A.get(j).ordinal()>=pivot.ordinal() ;-- j) {
        if(A.get(j).ordinal()>pivot.ordinal()){
          Collections.swap(A,i,j);
          break;
        }
      }

    }
  }

  //improved time complexity
  //O(n) space O(1)
  public static void dutchFlagPartitionImproved(int pivotlndex, List<Color> A){
    Color pivot=A.get(pivotlndex);

    //First pass: group elements smaller than pivot
    int smaller=0;
    for (int i = 0; i < A.size(); i++) {
      //smaller elements
      for (int j = i+1; j < A.size(); j++) {
        if(A.get(j).ordinal()<pivot.ordinal()){
          Collections.swap(A,smaller++,j);
          break;
        }

      }
    }

    //Second Pass: group elements larger than pivot.
    int larger= A.size()-1;
    for (int i = A.size()-1; i >=0 && A.get(i).ordinal()>=pivot.ordinal(); --i) {
      //Look for a larger element.Stop when we reach an element less
      //than pivot,since first pass moved them to the start of A.
      for (int j = i-1; j >=0 && A.get(j).ordinal()>=pivot.ordinal() ;-- j) {
        if(A.get(j).ordinal()>pivot.ordinal()){
          Collections.swap(A,larger--,j);
          break;
        }
      }

    }
  }

}
