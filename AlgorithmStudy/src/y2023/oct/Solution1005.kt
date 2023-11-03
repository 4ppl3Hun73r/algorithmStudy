package y2023.oct

// https://leetcode.com/problems/majority-element-ii/description/?envType=daily-question&envId=2023-10-05
class Solution1005 {
    fun majorityElement(nums: IntArray): List<Int> {

        val n = nums.size
        val appear: Double = n.toDouble() / 3f

        val cntMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            cntMap[num] = (cntMap[num] ?: 0) + 1
        }

        val ans = mutableListOf<Int>()
        for (mutableEntry in cntMap) {
            if (mutableEntry.value.toDouble() > appear) {
                ans.add(mutableEntry.key)
            }
        }

        return ans
    }
}