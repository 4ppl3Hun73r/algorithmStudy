package y2023.aug

// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
class Solution0831 {
    fun minTaps(n: Int, ranges: IntArray): Int {
        val dp = IntArray(n + 1)
        ranges.forEachIndexed { index, range ->
            if (range != 0) {
                val left = Math.max(0, index - range)
                dp[left] = Math.max(dp[left], index + range)
            }
        }

        var taps = 0
        var currEnd = 0
        var nextEnd = 0
        for (i in 0 .. n) {
            if (i > nextEnd) {
                return -1
            }
            if (i > currEnd) {
                taps++
                currEnd = nextEnd
            }

            nextEnd = Math.max(nextEnd, dp[i])
        }

        return taps
    }
}