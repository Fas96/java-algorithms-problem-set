package leetcode.Y2023.weekly.w329;
/*
*
* There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score, where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam. The matrix score contains distinct integers only.

You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores in the kth (0-indexed) exam from the highest to the lowest.

Return the matrix after sorting it.
*
*
*
* Input: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
*
*
*
* Input: score = [[3,4],[5,6]], k = 0
Output: [[5,6],[3,4]]
* */
public class Q6297SortTheStudentsByTheirKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
        int[][] res = new int[score.length][score[0].length];
        int[] temp = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            temp[i] = score[i][k];
        }
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (temp[i] > temp[j]) {
                    int[] t = score[i];
                    score[i] = score[j];
                    score[j] = t;
                    int tt = temp[i];
                    temp[i] = temp[j];
                    temp[j] = tt;
                }
            }
        }
        return score;

    }
}

