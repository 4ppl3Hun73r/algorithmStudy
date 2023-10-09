package y2023.sep

import java.util.*

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/?envType=daily-question&envId=2023-09-18
class Solution0918 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val comparator = Comparator.comparingInt<IntArray> { o -> o[1] }
                .thenComparingInt { o -> o[0]}

        val pq = PriorityQueue<IntArray>(comparator)

        for (i in 0 until mat.size) {
            var cnt = 0
            for (j in 0 until mat[i].size) {
                if (mat[i][j] == 1) {
                    cnt++
                } else {
                    break
                }
            }
            pq.offer(intArrayOf(i, cnt))
        }

        val ans = IntArray(k)

        for (i in 0 until k) {
            ans[i] = pq.poll()[0]
        }

        return ans
    }
}