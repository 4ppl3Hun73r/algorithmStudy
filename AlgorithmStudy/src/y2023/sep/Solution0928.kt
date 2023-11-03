package y2023.sep


// https://leetcode.com/problems/sort-array-by-parity/description/?envType=daily-question&envId=2023-09-28
class Solution0928 {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            if (nums[start] % 2 == 1) {
                while (start < end) {
                    if (nums[end] % 2 == 0) {
                        val temp = nums[start]
                        nums[start] = nums[end]
                        nums[end] = temp
                        break
                    }
                    end--
                }
            }
            start++
        }
        return nums
    }
}