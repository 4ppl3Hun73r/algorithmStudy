package y2023.sep

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/?envType=daily-question&envId=2023-09-21
class Solution0921 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val m = nums1.size
        val n = nums2.size
        var left = 0
        var right = m

        while (left <= right) {
            val partitionA = (left + right) / 2
            val partitionB = ((m + n + 1) / 2).toInt() - partitionA

            val maxLeftA = if (partitionA == 0) Int.MIN_VALUE else nums1[partitionA - 1]
            val minRightA = if (partitionA == m) Int.MAX_VALUE else nums1[partitionA]
            val maxLeftB = if (partitionB == 0) Int.MIN_VALUE else nums2[partitionB - 1]
            val minRightB = if (partitionB == m) Int.MAX_VALUE else nums2[partitionB]

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0
                } else {
                    return Math.max(maxLeftA, maxLeftB).toDouble()
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1
            } else {
                left = partitionA + 1
            }
        }
        return 0.0
    }
}