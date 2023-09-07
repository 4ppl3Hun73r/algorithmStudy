package y2023.aug

import java.util.*


// https://leetcode.com/problems/01-matrix/
class Solution0817 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m: Int = mat.size
        val n: Int = mat[0].size

        val updateMat = Array(m) { arrayOfNulls<Int>(n) }

        val queue: Queue<IntArray> = LinkedList()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 0) {
                    updateMat[i][j] = 0
                    queue.add(intArrayOf(i, j))
                }
            }
        }

        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        while (!queue.isEmpty()) {
            val cell = queue.poll()
            val origin = mat[cell[0]][cell[1]]
            for (dir in dirs) {
                val newX = cell[0] + dir[0]
                val newY = cell[1] + dir[1]
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                    continue
                }
                val visited = updateMat[cell[0]][cell[1]]
                val newVisited = updateMat[newX][newY]

                if (newVisited != null && (newVisited == 0 || newVisited <= visited!! + 1)) {
                    continue
                }
                queue.add(intArrayOf(newX, newY))
                updateMat[newX][newY] = updateMat[cell[0]][cell[1]]!! + 1
            }
        }
        val finalMat = Array(m) { IntArray(n) }
        for (i in updateMat.indices) {
            for (j in updateMat[i].indices) {
                finalMat[i][j] = if (updateMat[i][j] == null) 1 else updateMat[i][j]!!
            }
        }

        return finalMat
    }
}