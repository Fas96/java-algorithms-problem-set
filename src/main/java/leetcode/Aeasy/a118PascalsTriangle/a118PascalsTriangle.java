package leetcode.Aeasy.a118PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.util.Pair;

public class a118PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for(int i=0;i<numRows;i++)
    {
      row.add(0, 1);
      for(int j=1;j<row.size()-1;j++)
        row.set(j, row.get(j)+row.get(j+1));
      allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;

  }
  public static <A, B> List<Pair<A, B>> zipJava8(List<A> as, List<B> bs) {
    return IntStream.range(0, Math.min(as.size(), bs.size()))
        .mapToObj(i -> new Pair<>(as.get(i), bs.get(i)))
        .collect(Collectors.toList());
  }
}
