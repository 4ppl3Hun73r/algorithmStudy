package y2022.dec;


// https://leetcode.com/problems/climbing-stairs/
public class Solution1212 {

    public int climbStairs(int n) {
        // DP[0] = 0, DP[1] = 1, DP[2] = 2 , DP[3] = DP[2] + DP[1]
        // dp[n] = dp[n - 1] + dp[n-2]
        // 1 or 2
        /*
            n 까지 도달하기 위한 모든 경우의 수를 구하시오.
            1 or 2 가 가능함.
                                   0 -> 1 -> 1
                                   0 ->   -> 2
            dp[0] = 0, dp[1] = 1, dp[2] = 2

            1 -> 1
            2 -> 1 + 1
                 2
            3 -> (1) + 2
              -> (1 + 1) + 1
              -> (2) + 1
            4 -> (1 + 1) + 2
                 (2) + 2
                 (1 + 2) + 1
                 (1 + 1 + 1) + 1
                 (2 + 1) + 1


            1,2

            dp[n] = dp[n-1] + dp[n-2]
         */
        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        return dp[n];
    }
}
