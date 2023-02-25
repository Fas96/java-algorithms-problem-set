package leetcode.Y2023.weekly.w332;

//*
// 6356. Substring XOR Queries
//User Accepted:0
//User Tried:0
//Total Accepted:0
//Total Submissions:0
//Difficulty:Medium
//You are given a binary string s, and a 2D integer array queries where queries[i] = [firsti, secondi].
//
//For the ith query, find the shortest substring of s whose decimal value, val, yields secondi when bitwise XORed with firsti. In other words, val ^ firsti == secondi.
//
//The answer to the ith query is the endpoints (0-indexed) of the substring [lefti, righti] or [-1, -1] if no such substring exists. If there are multiple answers, choose the one with the minimum lefti.
//
//Return an array ans where ans[i] = [lefti, righti] is the answer to the ith query.
//
//A substring is a contiguous non-empty sequence of characters within a string.
// */
public class Q6356SubstringXORQueries {
    public int[][] substringXorQueries(String s, int[][] queries) {
int[][] ans = new int[queries.length][2];
        int n = s.length();
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = s.charAt(i) - '0';
        }
        for (int i = 1; i < n; i++) {
            prefix[i] ^= prefix[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int left = -1;
            int right = -1;
            for (int j = 0; j < n; j++) {
                int val = prefix[j];
                if (j > 0) {
                    val ^= prefix[j - 1];
                }
                if (val == second) {
                    left = j;
                    break;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                int val = prefix[j];
                if (j > 0) {
                    val ^= prefix[j - 1];
                }
                if (val == second) {
                    right = j;
                    break;
                }
            }
            ans[i][0] = left;
            ans[i][1] = right;
        }
        return ans;


    }
}
