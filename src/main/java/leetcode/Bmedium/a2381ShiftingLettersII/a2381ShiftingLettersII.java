package leetcode.Bmedium.a2381ShiftingLettersII;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class a2381ShiftingLettersII {
  @Test
  public  void test_shiftingLetters(){
    System.out.println(shiftingLetters("abc",new int[][]{{0,1,0},{1,2,1},{0,2,1}}));
  }
  public String shiftingLetters(String s, int[][] shifts) {
    Map<Character,Integer> smap= new HashMap<>();
    Map<Integer,Character> Rmap= new HashMap<>();
    for (int i = 0; i < 26; i++) {
      smap.put((char) (('a')+i),i);
      Rmap.put(i,(char) (('a')+i));
    }
    System.out.println(smap.size());
    for (int i = 0; i < shifts.length; i++) {
        String snew=s.substring(shifts[i][0],shifts[i][1]+1);
        StringBuilder made= new StringBuilder();
        for (int j = 0; j < snew.length(); j++) {

          int  getInt=(smap.get(snew.charAt(j))%26);
          if(shifts[i][2]==0) {
            //back
            if(getInt>0 && getInt<25){
              getInt-=1;
            }else{
              getInt=0;
            }
          }else{
            if(getInt>0 && getInt<25){
              getInt+=1;
            }else{
              getInt=25;
            }

          }
          System.out.println(getInt);
          made.append(Rmap.get(getInt));
          break;


      }

      s=s.replace(s.substring(shifts[i][0],shifts[i][1]+1),made);
      System.out.println(s);
      System.out.println(made+"--"+snew);
      System.out.println("___"+s);
//      System.out.println(s+"--"+made);
    }
    System.out.println(s);

    return  s;
  }

}
