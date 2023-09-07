package y2023.aug


// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
class Solution0809 {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        nums.sort()
        val n = nums.size
        var left = 0
        var right = nums[n - 1] - nums[0]

        while (left < right) {
            val mid = left + (right - left) / 2

            if (countPairs(nums, mid) >= p) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    fun countPairs(nums: IntArray, mid: Int): Int {
        var idx = 0
        var count = 0
        while (idx < nums.size - 1) {
            if (nums[idx + 1] - nums[idx] <= mid) {
                count++
                idx++
            }
            idx++
        }

        return count
    }
}

fun main() {
    val s = Solution0809()

    println(s.minimizeMax(intArrayOf(8,9,1,5,4,3,6,4,3,7), 4))
}