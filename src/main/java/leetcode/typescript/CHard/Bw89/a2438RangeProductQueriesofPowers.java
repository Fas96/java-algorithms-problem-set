package leetcode.typescript.CHard.Bw89;

import java.util.LinkedList;
import java.util.List;

public class a2438RangeProductQueriesofPowers {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            if ((n & (1 << i)) != 0) {
                list.add((int) Math.pow(2, i));
            }
        }

        int[] res = new int[queries.length];
        int mod = 1000000007;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            int product = 1;
            for (int j = left; j <= right; j++) {
                product = (int) ((product * (long) list.get(j)) % mod);
            }
            res[i] = product;
        }
        return res;


    }

}
