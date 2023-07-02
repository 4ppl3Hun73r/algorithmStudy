package y2023.jun

import java.util.*

// https://leetcode.com/problems/count-all-possible-routes/
class Solution0625 {
    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {

        val n = locations.size
        val dp = Array(n) {
            Array(fuel + 1) { 0 }
        }
        Arrays.fill(dp[finish] , 1)

        for (j in 0 .. fuel) {
            for (i in 0 until n) {
                for (k in 0 until n) {
                    if (k == i) {
                        continue
                    }
                    if (Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % 1000000007
                    }
                }
            }

        }

        return dp[start][fuel]

    }
}