package y2023.jul

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
class Solution0705 {
    fun longestSubarray(nums: IntArray): Int {

        var zeroCount = 0
        var windowSize = 0
        var windowStart = 0
        nums.forEachIndexed { index, i ->
            zeroCount += if (i == 0) 1 else 0
            while (zeroCount > 1) {
                zeroCount -= if (nums[windowStart] == 0) 1 else 0
                windowStart++
            }
            windowSize = windowSize.coerceAtLeast(index - windowStart)
        }

        return windowSize

    }
}