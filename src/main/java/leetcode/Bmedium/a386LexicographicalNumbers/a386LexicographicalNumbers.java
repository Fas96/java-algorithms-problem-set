package leetcode.Bmedium.a386LexicographicalNumbers;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class a386LexicographicalNumbers {
    @Test
    public void test() {
        assertEquals(Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9), lexicalOrder(13));

    }

        public List<Integer> lexicalOrder(int n){
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                dfs(i, n, ans);
            }
            return ans;
        }

    private void dfs(int i, int n, List<Integer> ans) {
        if (i > n) return;
        ans.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(i * 10 + j, n, ans);
        }

    }



}
