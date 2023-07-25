package y2023.jul

// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
class Solution0714 {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        /*
          dp[index] = dp[index ?? ] + 1
         */
        val dp = mutableMapOf<Int, Int>()

        var max = 0
        arr.forEach {
            dp[it] = (dp[it - difference] ?: 0 ) + 1
            max = max.coerceAtLeast(dp[it]!!)
        }

        return max
    }
}