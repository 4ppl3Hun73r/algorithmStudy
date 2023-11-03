package y2023.sep

// https://leetcode.com/problems/champagne-tower/description/?envType=daily-question&envId=2023-09-24
class Solution0924 {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val tower = Array(101) {
            DoubleArray(101)
        }

        tower[0][0] = tower[0][0] + poured

        for (i in 0 until 100) {
            for (j in 0 until i + 1) {
                if (tower[i][j] > 1.0) {
                    val over = (tower[i][j] - 1.0) / 2
                    tower[i + 1][j] = tower[i + 1][j] + over
                    tower[i + 1][j + 1] = tower[i + 1][j + 1] + over
                    tower[i][j] = 1.0
                }
            }
        }

        return tower[query_row][query_glass]

    }
}