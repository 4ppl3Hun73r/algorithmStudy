package y2023.aug

// https://leetcode.com/problems/number-of-music-playlists/
class Solution0806 {
    fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {

        val mod = 1000000007
        val dp = Array(goal + 1) {
            LongArray(n + 1) {
                0
            }
        }

        for ( i in 1 .. goal) {
            for (j in 1 .. Math.min(i,  n)) {
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % mod

                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % mod
                }
            }
        }

        return dp[goal][n].toInt()

    }
}