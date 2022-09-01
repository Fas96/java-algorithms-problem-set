package leetcode.Bmedium.a322CoinChange;

import org.junit.Test;

public class a322CoinChange {
  @Test
  public void coinChangeTest(){
    System.out.println(coinChange(new int[]{1,2,5},11));
  }


  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    dp[0] = 0;
    for (int i = 1; i <= amount; i++){
      int tmp = -1;
      for (int c : coins){
        if (i - c < 0 || dp[i - c] < 0) continue;
        if (tmp < 0) {
          tmp = dp[i - c] + 1;
        } else {
          tmp = Math.min(tmp, dp[i - c] + 1);
        }
      }
      dp[i] = tmp;
    }
    return dp[amount];
  }

  public int coinChangeI(int[] coins, int amount) {

    int M= amount;
    int N= coins.length;
    int dp[][]= new int[N+1][M+1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if(j>=coins[i-1]){
          dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
        }else {
          dp[i][j]=dp[i-1][j];
        }
      }

    }
    return  dp[N][M];
  }
}
