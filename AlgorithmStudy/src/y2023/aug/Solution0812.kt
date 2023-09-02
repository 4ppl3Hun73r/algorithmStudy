package y2023.aug

// https://leetcode.com/problems/unique-paths-ii/
class Solution0812 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val row: Int = obstacleGrid.size
        val col: Int = obstacleGrid[0].size
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0
        }

        for (y in 0 until row) {
            if (obstacleGrid[y][0] != 1) {
                obstacleGrid[y][0] = -1
            } else {
                break
            }
        }

        for (x in 0 until col) {
            if (obstacleGrid[0][x] != 1) {
                obstacleGrid[0][x] = -1
            } else {
                break
            }
        }


        for (i in 1 until row) {
            for (j in 1 until col) {
                if (obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] += if (obstacleGrid[i - 1][j] != 1) obstacleGrid[i - 1][j] else 0
                    obstacleGrid[i][j] += if (obstacleGrid[i][j - 1] != 1) obstacleGrid[i][j - 1] else 0
                }
            }
        }

        return -obstacleGrid[row - 1][col - 1]
    }
}