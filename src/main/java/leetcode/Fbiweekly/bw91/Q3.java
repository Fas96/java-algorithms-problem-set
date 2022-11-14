package leetcode.Fbiweekly.bw91;

import org.junit.Test;

public class Q3 {
    @Test
    public void testSol(){

    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
          int mod=1000000007;
            int n=amount.length;
            int[][] dp=new int[n][bob+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<=bob;j++){
                    dp[i][j]=-1;
                }
            }
            dp[0][bob]=amount[0];
            for(int i=0;i<n;i++){
                for(int j=0;j<=bob;j++){
                    if(dp[i][j]==-1) continue;
                    for(int[] edge:edges){
                        if(edge[0]==i){
                            int next=edge[1];
                            int cost=edge[2];
                            if(j>=cost){
                                dp[next][j-cost]=Math.max(dp[next][j-cost],dp[i][j]+amount[next]);
                            }
                        }
                    }
                }
            }
            int result=0;
            for(int i=0;i<=bob;i++){
                result=Math.max(result,dp[n-1][i]);
            }
            return result;


    }

}
