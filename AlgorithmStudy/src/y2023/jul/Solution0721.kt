package y2023.jul

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
class Solution0721 {
    fun findNumberOfLIS(nums: IntArray): Int {
        /*
        모든 증가하는 subsequence 를 구한뒤 가장 긴 subsequence 의 nums 를 반환
         */
        val n = nums.size
        val dp = IntArray(n) { 1 }
        val cnt = IntArray(n) { 1 }

        for (i in 0 until n) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1
                        cnt[i] = 0
                    }
                    if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j]
                    }
                }
            }
        }

        var max = 0
        for (i in dp) {
            max = i.coerceAtLeast(max)
        }

        var result = 0

        dp.forEachIndexed { index, i ->
            if (i == max) {
                result += cnt[index]
            }
        }

        return result
    }
}