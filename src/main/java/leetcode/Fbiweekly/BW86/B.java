package leetcode.Fbiweekly.BW86;

import org.junit.Test;

public class B {

  @Test
  public void testSol(){
    System.out.println(isStrictlyPalindromic(9));

  }
  public boolean isStrictlyPalindromic(int n) {

    for (int i = 2; i <=n ; i++) {
      if(!isPalindrome(Integer.toString(Integer.parseInt(n+"", 10), i)))return false;
    }
    return true;
  }
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while(left < right) {
      while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
      while(right > left && !Character.isLetterOrDigit(s.charAt(right))) right--;
      if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
      left++;
      right--;
    }
    return true;
  }
}
