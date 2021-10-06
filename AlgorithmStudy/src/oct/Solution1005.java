package oct;

// https://leetcode.com/problems/climbing-stairs/
public class Solution1005 {
    public int climbStairs(int n) {
        // 한번에 1 또는 2씩 올라갈수 있음 => (1, 2)
        // n까지 도달하는 경우의 수를 구하려 => (1, 2) 를 이용해 n 을 만드는 경우의 수

        // math, dp, memo
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

        /*
            dp[i] = dp[i - 1] + 1 ->
            dp[i] = dp[i - 1] + dp[i - 2] ->
            dp[0] = 0
            dp[1] = 1
            dp[2] = 2
            dp[3] = 3
            dp[4] = 5
            dp[5] = 8
            dp[6] = 13
            dp[7] = 21
            dp[8] = 34
            dp[9] = 55
            dp[10] = 89
            f(n) = f(n - 1) + f(n - 2), [f(1) = 1, f(2) = 2] : 점화식

        n = 2
        1. 1 + 1  -> 1
        2. 2      -> 2

        n = 3
        1. 1 + 1 + 1
        2. 1 + 2
        3. 2 + 1

        n = 4
           n = 2, +2칸
            1. 1 + 1 + 2
            2. 2 + 2
           n = 3, 1칸
            1. 1 + 1 + 1 + 1
            2. 1 + 2 + 1
            3. 2 + 1 + 1

        n = 5

       1. 1 + 1 + 1 + 1 + 1
       2. 1 + 1 + 1 + 2
       3. 1 + 1 + 2 + 1
       4. 1 + 2 + 1 + 1
       5. 1 + 2 + 2
       6. 2 + 1 + 1 + 1
       7. 2 + 1 + 2
       8. 2 + 2 + 1

         */
    }

    private int s(int n) {
        int res=0;
        if(n==0 || n==1) return 1;
        int a=1,b=1;
        for(int i=2;i<=n;i++){
            res=a+b;
            a=b;
            b=res;
        }
        return res;
    }
}
