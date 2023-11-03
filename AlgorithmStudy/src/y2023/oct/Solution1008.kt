package y2023.oct

// https://leetcode.com/problems/max-dot-product-of-two-subsequences/?envType=daily-question&envId=2023-10-08
class Solution1008 {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        var firstMax = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE
        var firstMin = Int.MAX_VALUE
        var secondMin = Int.MAX_VALUE

        for (num in nums1) {
            firstMax = Math.max(firstMax, num)
            firstMin = Math.min(firstMin, num)
        }

        for (num in nums2) {
            secondMax = Math.max(secondMax, num)
            secondMin = Math.min(secondMin, num)
        }

        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin
        }

        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax
        }


        val cache = Array(nums1.size) {
            IntArray(nums2.size)
        }

        return dfs(0, 0, nums1, nums2, cache)
    }

    private fun dfs(i: Int, j: Int, nums1: IntArray, nums2: IntArray, cache: Array<IntArray>): Int {
        if ( i == nums1.size || j == nums2.size) {
            return 0
        }
        if (cache[i][j] != 0) {
            return cache[i][j]
        }

        val use = nums1[i] * nums2[j] + dfs(i + 1, j + 1, nums1, nums2, cache)
        cache[i][j] = Math.max(use,
            Math.max(dfs(i + 1, j, nums1, nums2, cache), dfs(i, j + 1, nums1, nums2, cache))
        )

        return cache[i][j]
    }
}