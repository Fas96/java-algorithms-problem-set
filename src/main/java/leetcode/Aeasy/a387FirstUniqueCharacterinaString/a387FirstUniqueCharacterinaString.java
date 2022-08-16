package leetcode.Aeasy.a387FirstUniqueCharacterinaString;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class a387FirstUniqueCharacterinaString {
  @Test
  public void test_firstUniqChar(){
    System.out.println(firstUniqChar("aabb"));
  }
  public int firstUniqChar(String s) {

    int res=-1;
    List<Character> keeper=new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      int finalI = i;
      if (keeper.contains(s.charAt(finalI)))continue;
      long count = s.chars().filter(ch -> ch == s.charAt(finalI)).count();
      if(count==1 && !keeper.contains(s.charAt(finalI))){
        return finalI;
      }else{
        keeper.add(s.charAt(finalI));
      }
    }
    return res;

  }

  public int eFirstUniqChar(String s) {
    char[] a = s.toCharArray();
    for(int i=0; i<a.length;i++){
      if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
    }
    return -1;
  }
}
