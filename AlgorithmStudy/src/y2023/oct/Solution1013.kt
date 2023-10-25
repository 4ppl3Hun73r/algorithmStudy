package y2023.oct

class Solution1013 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = Array<Int>(cost.size + 1) { Int.MAX_VALUE }

        dp[0] = cost[0]
        dp[1] = cost[1]
        for (i in 2 until cost.size) {
            dp[i] = Math.min(dp[i], Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]))
        }

        return Math.min(dp[cost.size - 1], dp[cost.size - 2])
    }
}