package y2023.aug


// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution0808 {
    fun search(nums: IntArray, target: Int): Int {
        val len: Int = nums.size

        var start = 0
        var end = len - 1
        while (start < end) {
            val mid = (start + end) / 2
            val t = nums[mid]
            if (t == target) {
                return mid
            }

            //왼쪽 부터 중간까지는 정상 order
            if (nums[start] <= t) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
        }

        return if (nums[start] == target) start else -1
    }
}