package y2022.jul;

public class Solution0717 {
    int mod = (int) (1e9) + 7;

    public int kInversePairs(int n, int k) {
        // dp

        /*
        1 ~ n 까지 중 k개 뒤집어져 있다.

         dp[n][k] = n개의 길이에서 k개 뒤집어진 수

         dp[0][0] = 0
         dp[1][0] = 1
         dp[1][1] = 0
         dp[2][1] = 1
             0   1   2   3   4   5
         0  [  ][  ][  ][  ][  ][  ]
         1  [ 1][  ][  ][  ][  ][  ]
         2  [ 1][ 1][  ][  ][  ][  ]
              ^   ^   ^
                      l -> 3개의 합이 [3][2]의 dp 값
         3  [ 1][ 2][ 2][ 1][  ][  ]
         4  [  ][  ][  ][  ][  ][  ]
         */

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k && j <= i * (i - 1) / 2; j++) {
                if (i == 1 && j == 0) {
                    dp[i][j] = 1;
                    break;
                } else if (j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    int val = (dp[i - 1][j] + mod - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % mod;
                    dp[i][j] = (dp[i][j - 1] + val) % mod;
                }
            }
        }
        return dp[n][k];


    }
}
