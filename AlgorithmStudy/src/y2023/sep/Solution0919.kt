package y2023.sep

// https://leetcode.com/problems/find-the-duplicate-number/description/?envType=daily-question&envId=2023-09-19
class Solution0919 {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        fast = 0
        while (fast != slow) {
            fast = nums[fast]
            slow = nums[slow]
        }

        return slow
    }
}