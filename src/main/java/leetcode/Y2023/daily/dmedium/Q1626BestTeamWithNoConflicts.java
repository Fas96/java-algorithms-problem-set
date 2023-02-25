package leetcode.Y2023.daily.dmedium;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q1626BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(ages[i], scores[i]));
        }

        players.sort((a, b) -> {
            if (a.age == b.age) {
                return a.score - b.score;
            }
            return a.age - b.age;
        });
         ///print players
        for (Player player : players) {
            System.out.println(player);
        }
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = players.get(i).score;
            for (int j = 0; j < i; j++) {
                if (players.get(j).score <= players.get(i).score) {
                    dp[i] = Math.max(dp[i], dp[j] + players.get(i).score);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }
    class Player {
        int age;
        int score;
        public Player(int age, int score) {
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "age=" + age +
                    ", score=" + score +
                    '}';
        }
    }
    /*
    *
    *
    *
    * */
}
