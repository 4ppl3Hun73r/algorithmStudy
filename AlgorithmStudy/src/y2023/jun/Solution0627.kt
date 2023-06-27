package y2023.jun

import java.util.*

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
class Solution0627 {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        //nums1, nums2 오름차순
        //

        /*
         [1,1,2]
         [1,2,3]
         while (k && pq.isNotEmpty) {
             start = nums1[n1Idx]
             for (start <= nums2[n2Idx]) {
               n1Idx++
             }

             start2 = nums2[n2Idx]
             for (start2 <= num1[n1Idx]) {
             n 2Idx++
             }
             pq.poll()
             [1,1,2] -> idx 작은게 작다
             [1,2,3] -> nums1보다 작은게 있다면 그걸 쓰면됨

             pq.offer([1,1, 0, 0]) // nums1,nums2, idx1, idx2
             pq.offer(1)

             [1,1],[1,1],[2,1]
             [1,1] ->

            idx1 , idx2
            0,0
            0,1
            1,0
             pq.offer(2)

              }
         */

        val comparator = Comparator<IntArray> {
            o1, o2 ->
            (o1[0] + o1[1]) - (o2[0] + o2[1])
        }
        val pq = PriorityQueue(comparator)
        val visited = mutableSetOf<Pair<Int, Int>>()
        pq.offer(intArrayOf(nums1[0], nums2[0], 0, 0))
        visited.add(0 to 0)

        var k2 = k
        while (k2 != 0 && pq.isNotEmpty()) {
            val pos = pq.poll()
            res.add(listOf(pos[0], pos[1]))
            val idx1 = pos[2]
            val idx2 = pos[3]

            // idx1 + 1 , idx2
            // idx1 , idx2 + 1

            if (idx1 + 1 < nums1.size && !visited.contains(idx1 + 1 to idx2)) {
                pq.offer(intArrayOf(nums1[idx1+1], nums2[idx2], idx1+1, idx2))
                visited.add(idx1 + 1 to idx2)
            }
            if (idx2 + 1 < nums2.size && !visited.contains(idx1 to idx2 + 1)) {
                pq.offer(intArrayOf(nums1[idx1], nums2[idx2 + 1], idx1, idx2 + 1))
                visited.add(idx1 to idx2 + 1)
            }
            k2--
        }

        return res
    }
}