package leetcode.Y2023.weekly.w333;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q6363FindTheStringWithLCP {
    public String findTheString(int[][] lcp) {
        char result[] = new char[lcp.length], c = 'a';
        for (int i = 0; i < lcp.length; i++) {
            if (lcp[i][i] != lcp.length - i || result[i] == 0 && (result[i] = c++) > 'z') {
                return "";
            }
            for (int j = i + 1; j < lcp.length; j++) {
                if (lcp[i][j] != lcp[j][i]) {
                    return "";
                } else if (lcp[i][j] > 0) {
                    if (lcp[i][j] > lcp.length - j || result[j] != 0 && result[j] != result[i]) {
                        return "";
                    }
                    result[j] = result[i];
                }
            }
        }
        for (int i = 0; i < lcp.length; i++) {
            int[] z = z(String.valueOf(result, i, lcp.length - i));
            for (int j = i + 1; j < lcp.length; j++) {
                if (lcp[i][j] != z[j - i]) {
                    return "";
                }
            }
        }
        return new String(result);
    }

    private static int[] z(String s) {
        int[] z = new int[s.length()];
        for (int i = 1, x = 0, y = 0; i < s.length(); i++) {
            for (z[i] = Math.max(0, Math.min(z[i - x], y - i + 1)); i + z[i] < s.length()
                    && s.charAt(z[i]) == s.charAt(i + z[i]); y = i + z[x = i]++) {
            }
        }
        return z;

    }
    @Test
    public void test() {
        int[][] lcp = Ps.intArray("[[4,0,2,0],[0,3,0,1],[2,0,2,0],[0,1,0,1]]");
        assertEquals(findTheString(lcp), "abab");
        lcp = Ps.intArray("[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]");
        assertEquals(findTheString(lcp), "aaaa");
        lcp= Ps.intArray("[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,3]]");
        assertEquals(findTheString(lcp), "");
    }
}
