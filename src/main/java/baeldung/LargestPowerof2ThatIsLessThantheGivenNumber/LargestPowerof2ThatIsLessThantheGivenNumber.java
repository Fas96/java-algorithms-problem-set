package baeldung.LargestPowerof2ThatIsLessThantheGivenNumber;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LargestPowerof2ThatIsLessThantheGivenNumber {

  @Test
  public void givenIntegerWhen_findLargestPowerOf2LessThanTheGivenNumber() {
    assertEquals(8, findLargestPowerOf2LessThanTheGivenNumber(9));
    assertEquals(16, findLargestPowerOf2LessThanTheGivenNumber(32));
  }

  @Test
  public void givenIntegerWhen_findLargestPowerOf2LessThanTheGivenNumberUsingLogBase2() {
    assertEquals(8, findLargestPowerOf2LessThanTheGivenNumberUsingLogBase2(9));
    assertEquals(16, findLargestPowerOf2LessThanTheGivenNumberUsingLogBase2(32));
  }

  @Test
  public void givenIntegerWhen_findLargestPowerOf2LessThanTheGivenNumberUsingBitShiftApproach() {
    assertEquals(8, findLargestPowerOf2LessThanTheGivenNumberUsingBitShiftApproach(9));
    assertEquals(16, findLargestPowerOf2LessThanTheGivenNumberUsingBitShiftApproach(32));
  }

  //favorite
  @Test
  public void givenIntegerWhen_findLargestPowerOf2LessThanTheGivenNumberUsingBitwiseAnd() {
    assertEquals(8, findLargestPowerOf2LessThanTheGivenNumberUsingBitwiseAnd(9));
    assertEquals(16, findLargestPowerOf2LessThanTheGivenNumberUsingBitwiseAnd(32));

  }

  //O(log2(N))
  public long findLargestPowerOf2LessThanTheGivenNumber(long input) {
    assertTrue("Invalid input!Input must be greater than 1", input > 1);
    long firstPowerOf2 = 1;
    long nextPowerOf2 = 2;
    while (nextPowerOf2 < input) {
      firstPowerOf2 = nextPowerOf2;
      nextPowerOf2 = nextPowerOf2 * 2;
    }
    return firstPowerOf2;
  }

  //log2(x)=log10(x)/log10(2)
  //log2(8) = 3 and log2(16) = 4
  public long findLargestPowerOf2LessThanTheGivenNumberUsingLogBase2(long input) {
    assertTrue("Invalid input", input > 1);
    long temp = input;
    if (input % 2 == 0) {
      temp = input - 1;
    }
    long power = (long) (Math.log(temp) / Math.log(2));
    long result = (long) Math.pow(2, power);
    return result;
  }

  //Bitwise Technique

  /*
  *
20	1	0001
21	2	0010
22	4	0100
23	8	1000
  * */
//O(log2(N))
  public long findLargestPowerOf2LessThanTheGivenNumberUsingBitShiftApproach(long input) {
    assertTrue("Invalid input", input > 1);
    long result = 1;
    long powerOf2;
    System.out.println(Long.BYTES * 8);
    for (long i = 0; i < Long.BYTES * 8; i++) {
      //bitwise shift of 1
      powerOf2 = 1L << i;
      if (powerOf2 >= input) {
        break;
      }
      result = powerOf2;
    }
    return result;
  }

  //O(N/2)
  //Bitwise AND
  //2n AND 2n -1 = 0.
  //bitwise AND operation on these two numbers. 0100 AND 0011 is 0000
  public long findLargestPowerOf2LessThanTheGivenNumberUsingBitwiseAnd(long input) {
    assertTrue("Invalid input", input > 1);
    long result = 1;
    for (long i = input - 1; i > 1; i--) {
      if ((i & (i - 1)) == 0) {
        result = i;
        break;
      }
    }
    return result;
  }
}
