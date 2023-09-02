package y2023.jun

// https://leetcode.com/problems/last-day-where-you-can-still-cross/
class Solution0630 {
    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        /*
        [0 0 0]
        [0 0 0]
        [0 0 0]
         */
        var left = 1
        var right =cells.size

        while(left <= right){
            val mid = left + (right - left) / 2
            if (canCross(row, col, cells, mid)) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return right
    }

    fun canCross(row:Int,col:Int, cells: Array<IntArray>, days: Int): Boolean {
        val grid = Array(row) {
            IntArray(col) {
                0
            }
        }
        for (i in 0 until days) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1
        }

        for (i in 0 until col) {
            if (grid[0][i] == 0 && dfs(grid, 0, i, row, col)) {
                return true
            }
        }
        return false
    }

    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0))
    fun dfs(grid: Array<IntArray>, r: Int, c: Int, row: Int, col: Int ): Boolean {
        if (r < 0 || c < 0 || r == row || c == col || grid[r][c] != 0) {
            return false
        }

        if (r == row - 1) {
            return true
        }
        grid[r][c] = -1

        for (dir in dirs) {
            val newR = r + dir[0]
            val newC = c + dir[1]
            if (dfs(grid, newR, newC, row, col)) {
                return true
            }
        }

        return false
    }
}

fun main() {
    val s = Solution0630()
    println(s.latestDayToCross(2, 2, arrayOf(intArrayOf(1, 1), intArrayOf(2, 1),intArrayOf(1, 2),intArrayOf(2, 2))))
}