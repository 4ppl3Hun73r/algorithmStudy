package y2023.aug

// https://leetcode.com/problems/coin-change-ii/
class Solution0811 {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1

        for (i in coins.size - 1 downTo  0) {
            for (j in coins[i] .. amount) {
                dp[j] = dp[j - coins[i]];
            }
        }

        return dp[amount]

    }
}