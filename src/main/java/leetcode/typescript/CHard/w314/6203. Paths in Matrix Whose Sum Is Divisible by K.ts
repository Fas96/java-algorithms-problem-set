function numberOfPaths(grid: number[][], k: number): number {
//Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.

    //You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.
    //You can only move to the right or down at any point in time.


     //Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
    // Output: 2
    // Explanation: There are two paths where the sum of the elements on the path is divisible by k.
    // The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
    // The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.

    // Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7

    //Input: grid = [[0,0]], k = 5
    // Output: 1
    // Explanation: The path highlighted in red has a sum of 0 + 0 = 0 which is divisible by 5.

    let m=grid.length;
    let n=grid[0].length;
    let dp=new Array(m);
    for(let i=0;i<m;i++){
        dp[i]=new Array(n);
        for(let j=0;j<n;j++){
            dp[i][j]=new Array(k);
            for(let l=0;l<k;l++){
                dp[i][j][l]=0;
            }
        }
    }
    // Since the answer may be very large, return it modulo 109 + 7.
    let mod=1000000007;

dp[0][0][grid[0][0]%k]=1;
    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            for(let l=0;l<k;l++){
                if(i>0){
                    dp[i][j][(l+grid[i][j])%k]=(dp[i][j][(l+grid[i][j])%k]+dp[i-1][j][l])%mod;
                }
                if(j>0){
                    dp[i][j][(l+grid[i][j])%k]=(dp[i][j][(l+grid[i][j])%k]+dp[i][j-1][l])%mod;
                }
            }
        }
    }
    return dp[m-1][n-1][0];


    // dp[0][0][grid[0][0]%k]=1;
    // for(let i=0;i<m;i++){
    //     for(let j=0;j<n;j++){
    //         for(let l=0;l<k;l++){
    //             if(i>0){
    //                 dp[i][j][(l+grid[i][j])%k]+=dp[i-1][j][l];
    //             }
    //             if(j>0){
    //                 dp[i][j][(l+grid[i][j])%k]+=dp[i][j-1][l];
    //             }
    //         }
    //     }
    // }
    // // Since the answer may be very large, return it modulo 109 + 7.
    // return dp[m-1][n-1][0]%1000000007;

};
//test
describe('numberOfPaths', () => {
    it('numberOfPaths', () => {
        expect(numberOfPaths([[7,3,4,9],[2,3,6,2],[2,3,7,0]], 1)).toEqual(10);
        expect(numberOfPaths([[0,0]], 5)).toEqual(1);
        expect(numberOfPaths([[5,2,4],[3,0,5],[0,7,2]],3)).toEqual(2);
    }
    );
}
);