package y2023.sep

import java.util.*

// https://leetcode.com/problems/132-pattern/?envType=daily-question&envId=2023-09-30
class Solution0930 {
    fun find132pattern(nums: IntArray): Boolean {
        val stack = Stack<Int>()
        var third = Int.MIN_VALUE
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] < third) {
                return true
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop()
            }
            stack.push(nums[i])
        }

        return false
    }
}