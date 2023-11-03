package y2023.oct

import java.util.*

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=daily-question&envId=2023-10-09
class Solution1009 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var start = Arrays.binarySearch(nums, target)
        var end = start
        if (start < 0) {
            return intArrayOf(-1, -1)
        }

        var prevStart = start
        while (start >= 0) {
            prevStart = start
            start = Arrays.binarySearch(nums, 0, start, target)
        }

        var prevEnd = end
        while (end >= 0) {
            prevEnd = end
            end = Arrays.binarySearch(nums, end + 1, nums.size, target)
        }

        return intArrayOf(prevStart, prevEnd)

    }
}