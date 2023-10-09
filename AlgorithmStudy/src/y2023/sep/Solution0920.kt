package y2023.sep

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/?envType=daily-question&envId=2023-09-20
class Solution0920 {
    fun minOperations(nums: IntArray, x: Int): Int {
        var sum = nums.sum()
        var l = 0
        var r = 0
        var res = Int.MAX_VALUE
        val len = nums.size
        while (l <= r) {
            if (sum >= x) {
                if (sum == x) {
                    res = Math.min(res, l + len - r)
                }
                if (r < len) {
                    sum -= nums[r++]
                } else {
                    break
                }
            } else {
                sum += nums[l++]
            }
        }

        return if (res == Int.MAX_VALUE) -1 else res

    }
}