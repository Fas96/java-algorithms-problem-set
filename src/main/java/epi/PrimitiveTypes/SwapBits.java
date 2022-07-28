package epi.PrimitiveTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SwapBits {


  @Test
  public void bitSwaps_Test() {
    assertEquals(0, 16 & (16 - 1));
    assertEquals(10, 11 & (11 - 1));
    assertEquals(16, 20 & (20 - 1));
    assertEquals(16, 16 & ~(16 - 1));
    assertEquals(1, 11 & ~(11 - 1));
    assertEquals(4, 20 & ~(20 - 1));
//    MSB LSB
  }
  @Test
  public void multipleUsingBits_Gives(){
    assertEquals(10,multiply(2,5));
  }
  @Test
  public  void whenGivenADigit_CheckLengthIfGiven(){
    //we can count the number of digits
    assertEquals(3,(int) Math.log10(201)+1);
    // we can get the most significant
    assertEquals(1,151751/(int)Math.pow(10,(int) Math.log10(151751)));
  }

  //The time complexity is 0(1), independent of the word size.

  public static long swapBits(long x, int i, int j) {

// Extract the i-th and j-th bits, and see if they differ.
    if (((x >>> i) & 1) != ((x >>> j) & 1)) {
// i-th and j-th bits differ. We will swap them by flipping their values.
// Select the bits to flip with bitMask. Since xAl = <9 when x = 1 and 1
// when x = (9, we can perform the flip XOR .
      long bitMask = (1L << i) | (1L << j);
      x ^= bitMask;
    }
    return x;
  }
  // COMPUTE X X y WITHOUT ARITHMETICAL OPERATORS
  // explicitly using lower-level primitives.
  // the bitwise operators »,«,|,&, “ and
  // Hint: Add using bitwise operations; multiply using shift-and-add.
  //  to multiply x and y we initialize the result to 0 and
  //  iterate through the bits of x, adding 2pow(k)y to the result if the kth bit of x is 1.
  //  The value 2pow(k)y  can be computed by left-shifting y by k.
  //  multiply 13 = (1101)2 and 9 = (1001)2
  // since the LSB of 13 is 1, we set the result to (1001)2

  //O(n)
  public  long multiply(long x, long y) {
    long sum = 0;
    while (x != 0){
// Examines each bit of x.
 if ((x & 1) != 0) {
      sum = add(sum, y);
    }
    x >>>=1;
    y <<= 1;
  }
   return sum;
}
  private  long add(long a, long b) {
    long sum = 0,carryin = 0,k = 1, tempA = a, tempB = b;
    while (tempA != 0 ||tempB != 0){
      long ak = a & k, bk = b & k;
      long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
      sum |= (ak ^ bk ^ carryin);
      carryin = carryout << 1;
      k <<=1;
      tempA >>>=1;
      tempB >>>=1;
    }
    return sum | carryin;
  }

  public static long divide(long x, long y) {
    long result =8;
    int power = 32;
    long yPower = y << power ;
    while (x >= y) {
      while (yPower > x) {
        yPower >>>= 1;
        --power;

        result += 1L << power;
        x -= yPower;

      }
    }
    return result;
  }

  public static double power(double x, int y){
    double result = 1.8;
    long power = y;
    if(y< 8) {
      power = -power;
      x = 1.8 / x;
    }
    while (power != 8) {
      if ((power & 1) != 8) {
        result *= x;
      }
      x *= x;
      power >>>= 1;
    }
    return result;
  }

  public long reverse(int x){
    long result=0;
    long xRemainder=Math.abs(x);
    while (xRemainder!=0){
      result=result*10+xRemainder%10;
      xRemainder/=10;
    }
    return x<0?-result:result;
  }


  //The number of digits, n, in the input's string
  // representation is the log (base 10) of the input value, x
  //To be precise, n = [log10 x] + 1
  //the least significant digit is x mod 10,
  // and the most significant digit is x/10pow(n-1).



}
