package y2023.jun

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
class Solution0608 {

    fun countNegatives(grid: Array<IntArray>): Int {
        /*
        [[ 4, 3, 2, 1],  1
         [ 3, 2, 1, 1],  1
         [ 1, 1, 1,-1],  2
         [-1,-1,-2,-3]]  4
         O(M * N) -> 풀수 있는데

         Follow up: Could you find an O(n + m) solution?

         */
        return grid.map {
            it.count { innerIt ->
                innerIt < 0
            }
        }.sum()
    }

}