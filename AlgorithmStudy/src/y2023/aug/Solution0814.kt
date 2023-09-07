package y2023.aug

import java.util.*

// https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution0814 {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        val pq = PriorityQueue<Int>(Collections.reverseOrder<Int>())

        for (i in 0 until k) {
            pq.offer(nums[i])
        }
        for (i in k until nums.size) {
            if (nums[i] > pq.peek()) {
                pq.poll()
                pq.offer(nums[i])
            }
        }

        return pq.last()
    }
}