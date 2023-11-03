package y2023.oct

// https://leetcode.com/problems/number-of-good-pairs/?envType=daily-question&envId=2023-10-03
class Solution1003 {
    fun numIdenticalPairs(nums: IntArray): Int {
        /*

        (i, j) => nums[i] == nums[j] , i < j
         */

        val map = mutableMapOf<Int, Int>()
        var ans = 0
        for (num in nums) {
            ans += map[num] ?: 0
            map[num] = (map[num] ?: 0) + 1
        }
        return ans


    }
}