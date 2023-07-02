package y2023.jun

// https://leetcode.com/problems/check-if-it-is-a-straight-line/
class Solution0605 {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val (x0, y0) = coordinates[0]
        val (x1, y1) = coordinates[1]

        for (i  in 2 until coordinates.size) {
            val (x2, y2) = coordinates[i]

            if ((y0 - y1) * (x0 - x2) != (y0 - y2) * (x0 - x1)) {
                return false
            }
        }

        return true
    }
}