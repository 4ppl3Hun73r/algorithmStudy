package y2023.jul

// https://leetcode.com/problems/predict-the-winner/
class Solution0728 {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            dp[i][i] = nums[i]
        }

        for (diff in 1 until n) {
            for (left in 0 until n - diff) {
                val right = left + diff
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right],
                        nums[right] - dp[left][right - 1])
            }
        }

        return dp[0][n - 1] >= 0
    }
}