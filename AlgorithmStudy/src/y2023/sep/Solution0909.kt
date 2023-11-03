package y2023.sep

// https://leetcode.com/problems/combination-sum-iv/?envType=daily-question&envId=2023-09-09
class Solution0909 {
    var ans = 0
    lateinit var dp: IntArray
    fun combinationSum4(nums: IntArray, target: Int): Int {

        ans = 0
        dp = IntArray(target + 1) { -1 }
        nums.sort()

        return dfs(nums, target)
    }

    private fun dfs(nums: IntArray, target: Int): Int {
        if (target == 0) {
            return 1
        }
        if (dp[target] != -1) {
            return dp[target]
        }

        var value = 0
        for(i in 0 until nums.size) {
            val num = nums[i]
            val newTarget = target - num
            if (newTarget < 0) {
                break
            }
            value += dfs(nums, newTarget)
        }

        dp[target] = value
        return value
    }
}