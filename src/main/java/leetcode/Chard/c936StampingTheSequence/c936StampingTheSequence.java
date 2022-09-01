package leetcode.Chard.c936StampingTheSequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class c936StampingTheSequence {

  public int[] movesToStamp(String stamp, String target) {
    LinkedList<Integer> ans = new LinkedList<>();
    char[] T = target.toCharArray(), S = stamp.toCharArray();
    int sz, m = stamp.length(), n = target.length(), del = 0;

    do{ sz = ans.size();
      for (int i = 0; i < n - m + 1; i++){
        boolean ok = T[i] != 'X'; // ok to stamp?
        for (int j = i; j < i + m && ok; j++){
          ok &= T[j] == 'X' || T[j] == '?' || T[j] == S[j - i]; // all these conds must be met for stamp length
        }
        for (int j = i; j < i + m && ok; j++){
          if (Character.isLowerCase(T[j])){ // delete a letter
            del++;
          }
          T[j] = j == i || T[j] == 'X'? 'X' : '?'; // mark 'X' and '?' accordingly
        }
        if (ok){
          ans.addFirst(i);
        }
      }
    }while(sz != ans.size() && del != n);

    return del != n? new int[0] : ans.stream().mapToInt(o -> o).toArray();
  }
}
