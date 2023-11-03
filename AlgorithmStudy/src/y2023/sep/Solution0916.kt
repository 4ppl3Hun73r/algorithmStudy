package y2023.sep

import java.util.*

// https://leetcode.com/problems/path-with-minimum-effort/description/?envType=daily-question&envId=2023-09-16
class Solution0916 {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val dirs = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, -1),
            intArrayOf(1, 0), intArrayOf(-1, 0),
        )

        var min = Int.MAX_VALUE
        val row = heights.size
        val col = heights[0].size
        val visited = Array(row) {
            BooleanArray(col)
        }
        val queue = PriorityQueue<IntArray>(Comparator.comparingInt { a -> a[0] })
        queue.add(intArrayOf(0, 0, 0))
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            val maxPath = node[0]
            val r = node[1]
            val c = node[2]

            if (r == row - 1 && c == col - 1) {
                min = Math.min(min, maxPath)
            }
            visited[r][c] = true
            for (dir in dirs) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                if (newR < 0 || newC > 0 || newR == row || newC == col || visited[newR][newC]) {
                    continue
                }
                val maxDiff = Math.max(maxPath, Math.abs(heights[newR][newC] - heights[r][c]))
                queue.add(intArrayOf(maxDiff, newR, newC))
            }
        }

        return min

    }
}