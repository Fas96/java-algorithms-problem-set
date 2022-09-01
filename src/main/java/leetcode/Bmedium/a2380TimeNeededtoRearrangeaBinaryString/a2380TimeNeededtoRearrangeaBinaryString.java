package leetcode.Bmedium.a2380TimeNeededtoRearrangeaBinaryString;

import org.junit.Test;

public class a2380TimeNeededtoRearrangeaBinaryString {

  @Test
  public void  secondsToRemoveOccurrences_Test(){
    System.out.println(secondsToRemoveOccurrences("11100"));
  }
  public int secondsToRemoveOccurrences(String s) {
    int res=0;

    while (s.contains("01")){
     if(s.contains("01")){
       System.out.println(":"+s);
       s=s.replaceAll("01","10");
       res++;
     }else{
       break;
     }
    }
    return res;
  }
}
