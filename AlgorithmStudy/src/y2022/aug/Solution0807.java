package y2022.aug;

import java.util.Random;

// https://leetcode.com/problems/count-vowels-permutation/
public class Solution0807 {
    public int countVowelPermutation(int n) {
        /*
        각 문자는 소문자 모음('a', 'e', 'i', 'o', 'u')입니다.
        각 모음 'a' 뒤에는 'e'만 올 수 있습니다.
        각 모음 'e' 뒤에는 'a' 또는 'i'만 올 수 있습니다.
        각 모음 'i' 뒤에 다른 'i'가 올 수 없습니다.
        각 모음 'o' 뒤에는 'i' 또는 'u'만 올 수 있습니다.
        각 모음 'u' 뒤에는 'a'만 올 수 있습니다.

        "ea"
        "ua"
        "ia"
        "ae"
        "ie"
        "ei"
        "oi"
        "io"
        "iu"
        "ou"



        dp[0][i] = a 가 붙을 수 있는 것 dp[1][i - 1] + dp[2][i - 1] + dp[4][i - 1]
        dp[1][i] = e 가 붙을 수 있는 것 dp[0][i - 1] + dp[2][i - 1]
        dp[2][i] = i 가 붙을 수 있는 것 dp[1][i - 1] + dp[3][i - 1]
        dp[3][i] = o 가 붙을 수 있는 것 dp[2][i - 1]
        dp[4][i] = u 가 붙을 수 있는 것 dp[2][i - 1] + dp[3][i - 1]

         */

        long[][] dp = new long[5][n];
        for (int i = 0; i < 5; i++) {
            dp[i][0] = 1;
        }

        int mod = 1000000007;
        for (int i = 1; i < n; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1] + dp[4][i - 1])%mod;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1])%mod;
            dp[2][i] = (dp[1][i - 1] + dp[3][i - 1])%mod;
            dp[3][i] = (dp[2][i - 1])%mod;
            dp[4][i] = (dp[2][i - 1] + dp[3][i - 1])%mod;
        }

        return (int)((dp[0][n - 1] + dp[1][n - 1] + dp[2][n - 1] + dp[3][n - 1] + dp[4][n - 1]) % mod);

    }
    
    public static void main(String[] args) {
        Random random  = new Random();
        for (int i = 1; i <= 1000; i++) {
            System.out.println(random.nextInt(20001));
            
        }
    }
}
