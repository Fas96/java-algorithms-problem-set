package epi.arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import org.junit.Test;

public class ArrayManipulator {

  @Test
  public void evenOddOrder_IFExistOrEven(){
    assertArrayEquals(new int[]{8, 6, 232, 2, 4, 3, 1, 7, 1},evenOdd(new int[]{8,1,232,2,1,3,4,6,7}));
  }

  public int[] evenOdd(int[]A){
    int nextEven=0,nextOdd=A.length-1;
    while (nextEven<nextOdd){
      if(A[nextEven]%2==0){
        nextEven++;
      }else {
        int temp=A[nextEven];
        A[nextEven]=A[nextOdd];
        A[nextOdd--]=temp;
      }
    }
    return A;
  }

}
