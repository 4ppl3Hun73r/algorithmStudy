package y2023.oct

// https://leetcode.com/problems/count-vowels-permutation/submissions/767221509/?envType=daily-question&envId=2023-10-28
class Solution1028 {
    fun countVowelPermutation(n: Int): Int {
        val dp = Array(5) {
            LongArray(n) { 0 }
        }
        for (i in 0 until 5) {
            dp[i][0] = 1
        }

        val mod = 1000000007
        for (i in 1 until n) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1] + dp[4][i - 1])%mod;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1])%mod;
            dp[2][i] = (dp[1][i - 1] + dp[3][i - 1])%mod;
            dp[3][i] = (dp[2][i - 1])%mod;
            dp[4][i] = (dp[2][i - 1] + dp[3][i - 1])%mod;
        }

        return ((dp[0][n - 1] + dp[1][n - 1] + dp[2][n - 1] + dp[3][n - 1] + dp[4][n - 1]) % mod).toInt()

    }
}