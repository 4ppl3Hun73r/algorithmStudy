package aug

class Solution0803kt {
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val numsWithIndex: Iterable<IndexedValue<Int>> = nums.withIndex()

            val sortedNumsWithIndex: List<IndexedValue<Int>> = numsWithIndex.sortedBy(IndexedValue<Int>::value)

            val sortedNums = sortedNumsWithIndex.map { it.value }.toIntArray()

            for ((originalIndex, value) in sortedNumsWithIndex) {
                val targetIndexInSortedNums = binarysearch(sortedNums, target - value, 0, sortedNums.size)
                if (targetIndexInSortedNums == -1) continue

                val targetIndex = sortedNumsWithIndex[targetIndexInSortedNums].index
                if (originalIndex == targetIndex) {
                    val candidateTarget = sortedNums[targetIndexInSortedNums]
                    return when {
                        targetIndexInSortedNums - 1 > 0 && sortedNums[targetIndexInSortedNums - 1] == candidateTarget ->
                            intArrayOf(sortedNumsWithIndex[targetIndexInSortedNums - 1].index, originalIndex)
                        targetIndexInSortedNums + 1 < nums.size && sortedNums[targetIndexInSortedNums + 1] == candidateTarget ->
                            intArrayOf(originalIndex, sortedNumsWithIndex[targetIndexInSortedNums + 1].index)
                        else -> throw IllegalArgumentException()
                    }
                } else {
                    return intArrayOf(originalIndex, targetIndex)
                }
            }
            throw IllegalArgumentException()
        }

        // bb bb
        private fun binarysearch(nums: IntArray, value: Int, start: Int, end: Int): Int {
            val center = (start + end) / 2
            return if (start < 0 || end >= nums.size || center >= nums.size) {
                -1
            } else if (nums[center] == value) {
                center
            } else if (start == end) {
                -1
            } else if (nums[center] < value) {
                binarysearch(nums, value, center + 1, end)
            } else {
                binarysearch(nums, value, start, center - 1)
            }
        }
    }

}