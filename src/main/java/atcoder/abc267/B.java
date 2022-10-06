package atcoder.abc267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {

//  Each of the columns has one or more standing pins
//There exists a column between these columns such that all pins in the column are knocked down.
//S is 0 if Pin i is knocked down, and is 1 if it is
  public static void main(String[] args) throws IOException {
    Map<Integer,List<Integer>> hm= new HashMap<>();
    Map<Integer,List<Integer>> hpins= new HashMap<>();
    for (int i = 1; i < 8; i++) {
      if(i==1) hm.put(i ,Arrays.asList(7));
      if(i==2) hm.put(i ,Arrays.asList(4));
      if(i==3) hm.put(i ,Arrays.asList(2,8));
      if(i==4) hm.put(i ,Arrays.asList(1,5));
      if(i==5) hm.put(i ,Arrays.asList(9,3));
      if(i==6) hm.put(i ,Arrays.asList(6));
      if(i==7) hm.put(i ,Arrays.asList(10));
    }
    String s="1101110101";
    for (int i = 0; i < s.length(); i++) {
      char at = s.charAt(i);
      for (int j = 0; j < hm.size(); j++) {
        if(hm.get(j+1).contains(i+1)){
          System.out.println(hm.get(j+1)+":::"+at);
        }
      }

    }
    System.out.println(hm);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String pins=reader.readLine();
  }

}
