package y2023.aug

// https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
class Solution0830 {
    fun minimumReplacement(nums: IntArray): Long {
        var ans: Long = 0

        val len = nums.size

        for (i in len - 2 downTo 0) {
            if (nums[i] <= nums[i + 1]) {
                continue
            }
            val numElements = (nums[i] + nums[i + 1] - 1).toLong() / nums[i + 1].toLong()
            ans += numElements - 1

            nums[i] = nums[i] / numElements.toInt()
        }

        return ans

    }
}