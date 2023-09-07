package y2023.aug

// https://leetcode.com/problems/search-a-2d-matrix/
class Solution0807 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val row = matrix.size
        val col = matrix[0].size

        var targetRow = -1
        for (i in 0 until row) {
            if (target in matrix[i][0] .. matrix[i][col - 1]) {
                targetRow = i
                break
            }
        }

        if (targetRow == -1) {
            return false
        }

        return matrix[targetRow].binarySearch(target) > -1
    }
}