package leetcode.Bmedium.a1680ConcatenationofConsecutiveBinaryNumbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class a1680ConcatenationofConsecutiveBinaryNumbers {
    @Test
    public void test() {
        assertEquals(27, concatenatedBinary(3));
        assertEquals(505379714, concatenatedBinary(12));
        List<List<Integer>> ans = new ArrayList<>();
        getMaxOfEachList(ans);
    }

    private List<Integer> getMaxOfEachList(List<List<Integer>> ans)  {
        List<Integer> max = new ArrayList<>();
        for (List<Integer> list : ans) {
            max.add(list.stream()
                    .mapToInt(v -> v)
                    .max().orElseThrow(NoSuchElementException::new));
        }
        return max;
    }

    public int concatenatedBinary(int n) {
       String binaryString  ="";
       long ans=0;
         for (int i = 1; i <= n; i++) {
              binaryString+=Integer.toBinaryString(i);
         }
            for (int i = 0; i < binaryString.length(); i++) {
                ans=(ans*2+binaryString.charAt(i)-'0')%(1000000007);
            }
            return (int) ans;
    }


}
