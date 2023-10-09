package y2023.sep

import java.util.*

// https://leetcode.com/problems/min-cost-to-connect-all-points/?envType=daily-question&envId=2023-09-15
class Solution0915 {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        var min = 0
        var connected = 1
        val dsu = DSU(n)
        val pq = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])
                pq.offer(intArrayOf(cost, i, j))
            }
        }

        while (pq.isNotEmpty()) {
            val edge = pq.poll()
            if (dsu.union(edge[1], edge[2])) {
                min += edge[0]
                connected++
            } else if (connected == n) {
                return min
            }
        }
        return min
    }

    class DSU(n: Int) {
        val parent = IntArray(n) {
            it
        }
        val rank = IntArray(n)

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)
            if (px == py) {
                return false
            }
            if (rank[px] > rank[py]) {
                parent[py] = px
            } else if (rank[py] > rank[px]) {
                parent[px] = py
            } else {
                parent[py] = px
                rank[px] ++
            }
            return true
        }
    }
}