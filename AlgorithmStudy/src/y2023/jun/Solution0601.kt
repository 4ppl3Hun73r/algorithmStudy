package y2023.jun

import java.util.*

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution0601 {

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val len = grid.size
        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }

        val dirs = arrayOf(
                arrayOf(-1, -1), arrayOf(-1, 0),
                arrayOf(-1, 1), arrayOf(0, -1),
                arrayOf(0, 1), arrayOf(1, -1),
                arrayOf(1, 0), arrayOf(1, 1)
        )

        // val visited = booleanArrayOf()
        val visited = Array(len) {
            BooleanArray(len)
        }

        val queue: Queue<IntArray> = LinkedList()
        visited[0][0] = true
        queue.offer(intArrayOf(0, 0, 1))

        while (queue.isNotEmpty()) {
            val node: IntArray = queue.poll()
            val y = node[0]
            val x = node[1]
            val nextCount = node[2] + 1

            if (y == len - 1 && x == len - 1) {
                return node[2]
            }
            for (dir in dirs) {
                val newX = x + dir[0]
                val newY = y + dir[1]
                if (newX < 0 || newY < 0 || newX == len || newY == len || grid[newY][newX] == 1) {
                    continue
                }
                if (visited[newY][newX]) {
                    continue
                }
                visited[newY][newX] = true
                queue.add(intArrayOf(newY, newX, nextCount))
            }
        }

        return -1
    }
}