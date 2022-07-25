package baeldung.perfectSquares;

import static org.junit.Assert.assertEquals;

import com.sun.glass.ui.Clipboard;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class PerfectSquaresIntegers {
  @Test
  public void  whenGivenInteger_lastDigitIs(){
    //BIT operation
    //base 16 operation gives
    assertEquals(9,(int)((121) & 0xF));
  }
  @Test
  public void whenGivenInteger_isPerfectSquareUsingSqrt(){
    assertEquals(true,isPerfectSquareByUsingSqrt(9));
  }

  @Test
  public void whenGivenInteger_isPerfectSquareByUsingBinarySearch(){
    assertEquals(true,isPerfectSquareByUsingBinarySearch(0L,(long) Math.pow(2,63),9L));
  }
  public static boolean isPerfectSquareByUsingSqrt(long n) {
    if (n <= 0) {
      return false;
    }
    double squareRoot = Math.sqrt(n);
    //precision errors we can encounter when dealing with double values
    long tst = (long)(squareRoot + 0.5);
    return tst*tst == n;
  }
  public boolean isPerfectSquareByUsingBinarySearch(long low,long high,long number){
    long check = (low + high) / 2L;
    if (high < low) {
      return false;
    }
    if (number == check * check) {
      return true;
    }
    else if (number < check * check) {
      high = check - 1L;
      return isPerfectSquareByUsingBinarySearch(low, high, number);
    }
    else {
      low = check + 1L;
      return isPerfectSquareByUsingBinarySearch(low, high, number);
    }
  }

  //Enhancements on Binary Search

  /*
  *
  * For example, if the number consists of one digit only,
  * then the range of the square root is between 1 and 4.
  *  The reason is that the maximum integer from one digit is 9 and its root is 3.
  *  In addition, if the number is composed of two digits,
  *  the range is between 4 and 10, and so on.
  * */
  List<BinarySearchRange> lookupTable=new LinkedList<>();
  private void initiateOptimizedBinarySearchLookupTable() {

    lookupTable.add(new BinarySearchRange());
    lookupTable.add(new BinarySearchRange(1L, 4L));
    lookupTable.add(new BinarySearchRange(3L, 10L));
    for (int i = 3; i < 20; i++) {
      lookupTable.add(
          new BinarySearchRange(lookupTable.get(i - 2).getLow() * 10, lookupTable.get(i - 2).getHigh() * 10));
    }
  }
  public boolean isPerfectSquareByUsingOptimizedBinarySearch(long number) {
    int numberOfDigits = Long.toString(number).length();
    return isPerfectSquareByUsingBinarySearch(
        lookupTable.get(numberOfDigits).getLow(), lookupTable.get(numberOfDigits).getHigh(),

        number);
  }

  public static boolean isPerfectSquareByUsingNewtonMethod(long n) {
    long x1 = n;
    long x2 = 1L;
    while (x1 > x2) {
      x1 = (x1 + x2) / 2L;
      x2 = n / x1;
    }
    return x1 == x2 && n % x1 == 0L;
  }

  //Optimizing Integer Square Root Algorithms
  /*
  * One of the facts that we can use is
  *  “perfect squares can only end in 0, 1, 4, or 9 in base 16”.
  * So, we can convert an integer to base 16 before starting the
  * computations. After that, we exclude the cases that consider
  * the number as a non-perfect square root:
  * */
  public static boolean isPerfectSquareWithOptimization(long n) {
    if (n < 0) {
      return false;
    }
    //give the least significant digit
    switch((int)(n & 0xF)) {
      case 0: case 1: case 4: case 9:
        long tst = (long)Math.sqrt(n);
        return tst*tst == n;
      default:
        return false;
    }
  }
}
