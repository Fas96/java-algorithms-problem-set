package leetcode.Y2023.daily.deasy;

import org.junit.Test;

import java.util.*;
/*
*
* In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
* */
public class Q997FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {

        //base case
        if (n == 1) return 1;
        if (trust.length == 0) return -1;


        Set<Integer> trustiee = new HashSet<>();
        Set<Integer> person = new HashSet<>();
        for (int[] t : trust) {
            trustiee.add(t[0]);
            person.add(t[1]);
        }

        for (int p : person) {
            if (!trustiee.contains(p)) {
                int count = 0;
                //The town judge trusts nobody.
                for (int[] t : trust) {
                    if (t[1] == p) count++;
                }
                if (count == n - 1) return p;
            }
        }
        return -1;

    }

    @Test
    public void test() {
        System.out.println( findJudge(2, new int[][]{{1, 2}}));
        // n = 3, trust = [[1,3],[2,3]]
        System.out.println( findJudge(3, new int[][]{{1, 3}, {2, 3}}));

        //n = 3, trust = [[1,3],[2,3],[3,1]]
        System.out.println( findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        //3  [[1,2],[2,3]]
        System.out.println( findJudge(3, new int[][]{{1, 2}, {2, 3}}));
    }
}
