package y2023.aug

// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
class Solution0813 {

    val cache: MutableMap<Int, Boolean> = mutableMapOf()
    fun validPartition(nums: IntArray): Boolean {
        cache[-1] = true

        return backtracking(nums, nums.size - 1)
    }

    private fun backtracking(nums: IntArray, idx: Int): Boolean {
        if (cache[idx] != null) {
            return cache[idx]!!
        }

        var ans = false
        if (idx > 0 && nums[idx] == nums[idx - 1]) {
            ans = ans or backtracking(nums, idx - 2)
        }
        if (idx > 1 && nums[idx] == nums[idx - 1] && nums[idx - 1] == nums[idx - 2]) {
            ans = ans or backtracking(nums, idx - 3)
        }
        if (idx > 1 && nums[idx] == nums[idx - 1] + 1 && nums[idx - 1] == nums[idx - 2] + 1) {
            ans = ans or backtracking(nums, idx - 3)
        }

        cache[idx] = ans

        return ans

    }
}