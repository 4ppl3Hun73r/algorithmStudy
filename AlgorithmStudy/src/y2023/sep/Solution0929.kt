package y2023.sep

// https://leetcode.com/problems/monotonic-array/description/?envType=daily-question&envId=2023-09-29
class Solution0929 {
    fun isMonotonic(nums: IntArray): Boolean {
        var inc: Boolean? = null

        for (i in 0 until nums.size - 1) {
            val diff = nums[i] - nums[i + 1]
            if (diff == 0) {
                continue
            }
            val nextInc = nums[i] - nums[i + 1] < 0

            if ( inc != null && inc != nextInc ) {
                return false
            }
            inc = nextInc
        }
        return true
    }
}