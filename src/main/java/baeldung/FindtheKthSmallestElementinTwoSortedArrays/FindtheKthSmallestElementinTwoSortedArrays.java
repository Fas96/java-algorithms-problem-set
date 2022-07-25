package baeldung.FindtheKthSmallestElementinTwoSortedArrays;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.Test;

/*
* find the kth-smallest element in the union of two sorted arrays.
*efficient solution based on a binary search on the two arrays
*  */
public class FindtheKthSmallestElementinTwoSortedArrays {

/*
The simplest way to find the kth smallest
 element is to join the arrays, sort them,
  and return the kth element of the resulting
  array:
* */

  // O(n log n)
  //create a copy of the array, which results in more space needed.
  int getKthElementSorted(int[] list1, int[] list2, int k) {

    int length1 = list1.length, length2 = list2.length;
    int[] combinedArray = new int[length1 + length2];
    System.arraycopy(list1, 0, combinedArray, 0, list1.length);
    System.arraycopy(list2, 0, combinedArray, list1.length, list2.length);
    Arrays.sort(combinedArray);

    return combinedArray[k-1];
  }


  //O(k).
  //consider duplicate elements only once.
  //we don't copy the full arrays, but stop when the resulting array has k elements.
  public static int getKthElementMerge(int[] list1, int[] list2, int k) {

    int i1 = 0, i2 = 0;

    while(i1 < list1.length && i2 < list2.length && (i1 + i2) < k) {
      if(list1[i1] < list2[i2]) {
        i1++;
      } else {
        i2++;
      }
    }

    if((i1 + i2) < k) {
      return i1 < list1.length ? list1[k - i2 - 1] : list2[k - i1 - 1];
    } else if(i1 > 0 && i2 > 0) {
      return max(list1[i1-1], list2[i2-1]);
    } else {
      return i1 == 0 ? list2[i2-1] : list1[i1-1];
    }
  }

  //A Binary Search Over Both Arrays

  public  int findKthElement(int k, int[] list1, int[] list2) throws NoSuchElementException, IllegalArgumentException {

    checkInput(k, list1, list2);

    // we are looking for the minimum value
    if(k == 1) {
      return min(list1[0], list2[0]);
    }

    // we are looking for the maximum value
    if(list1.length + list2.length == k) {
      return max(list1[list1.length-1], list2[list2.length-1]);
    }

    // swap lists if needed to make sure we take at least one element from list1
    if(k <= list2.length && list2[k-1] < list1[0]) {
      int[] list1_ = list1;
      list1 = list2;
      list2 = list1_;
    }

    // correct left boundary if k is bigger than the size of list2
    int left = k < list2.length ? 0 : k - list2.length - 1;

    // the inital right boundary cannot exceed the list1
    int right = min(k-1, list1.length - 1);

    int nElementsList1, nElementsList2;

    // binary search
    do {
      nElementsList1 = ((left + right) / 2) + 1;
      nElementsList2 = k - nElementsList1;

      if(nElementsList2 > 0) {
        if (list1[nElementsList1 - 1] > list2[nElementsList2 - 1]) {
          right = nElementsList1 - 2;
        } else {
          left = nElementsList1;
        }
      }
    } while(!foundCorrectNumberOfElementsInBothLists(list1, list2, nElementsList1, nElementsList2));

    return nElementsList2 == 0 ? list1[nElementsList1-1] : max(list1[nElementsList1-1], list2[nElementsList2-1]);
  }

  private static boolean foundCorrectNumberOfElementsInBothLists(int[] list1, int[] list2, int nElementsList1, int nElementsList2) {

    // we do not take any element from the second list
    if(nElementsList2 < 1) {
      return true;
    }

    if(list1[nElementsList1-1] == list2[nElementsList2-1]) {
      return true;
    }

    if(nElementsList1 == list1.length) {
      return list1[nElementsList1-1] <= list2[nElementsList2];
    }

    if(nElementsList2 == list2.length) {
      return list2[nElementsList2-1] <= list1[nElementsList1];
    }

    return list1[nElementsList1-1] <= list2[nElementsList2] && list2[nElementsList2-1] <= list1[nElementsList1];
  }

  void checkInput(int k, int[] list1, int[] list2) throws NoSuchElementException, IllegalArgumentException {

    if(list1 == null || list2 == null || k < 1) {
      throw new IllegalArgumentException();
    }

    if(list1.length == 0 || list2.length == 0) {
      throw new IllegalArgumentException();
    }

    if(k > list1.length + list2.length) {
      throw new NoSuchElementException();
    }
  }
  //test code
  int[] sortedRandomIntArrayOfLength(int length) {
    int[] intArray = new Random().ints(length).toArray();
    Arrays.sort(intArray);
    return intArray;
  }

  private void random() {

    Random random = new Random();
    int length1 = (Math.abs(random.nextInt())) % 1000 + 1;
    int length2 = (Math.abs(random.nextInt())) % 1000 + 1;

    int[] list1 = sortedRandomIntArrayOfLength(length1);
    int[] list2 = sortedRandomIntArrayOfLength(length2);

    int k = (Math.abs(random.nextInt()) + 1) % (length1 + length2);

    int result = findKthElement(k, list1, list2);
    int result2 = getKthElementSorted(list1, list2, k);
    int result3 = getKthElementMerge(list1, list2, k);

    assertEquals(result2, result);
    assertEquals(result2, result3);
  }
  @Test
  public void randomTests() {
    random();
  }

}
