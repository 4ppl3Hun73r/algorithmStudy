package y2023.jun


// https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
class Solution0616 {
    fun numOfWaysFail(nums: IntArray): Int {
        val mod = 1e9.toInt() + 7

        // [3,4,5,1,2]
        // [3,1,2,4,5]
        // [3,1,4,2,5]
        // [3,1,4,5,2]
        // [3,4,1,2,5]
        // [3,4,1,5,2]


        // 3 [ 1, 4 ]
        // 2 는 1다음에 오면 언제오든 상관 없다.
        // 5 도 다음에 오면 언제오든 상관 없다.

        //
        /*
        // [1][2][][ ][ ]
        //
        // [3,4,5,1,2] ->

        // [3][1][2][4][5]
                 [4][5][2]
                    [2][5]
              [4][1][5][2]
                    [2][5]
                 [5][1][2]

         */


        //      3
       //    1      4
       //       2       5

        return 0
    }

    private val mod = 1e9.toLong() + 7
    private lateinit var table: Array<LongArray>

    fun numOfWays(nums: IntArray): Int {
        val m = nums.size

        // Table of Pascal's triangle
        table = Array(m) { LongArray(m) }
        for (i in 0 until m) {
            table[i][i] = 1
            table[i][0] = table[i][i]
        }
        for (i in 2 until m) {
            for (j in 1 until i) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod
            }
        }
        val arrList = nums.toList()
        return ((dfs(arrList) - 1) % mod).toInt()
    }

    private fun dfs(nums: List<Int>): Long {
        val m = nums.size
        if (m < 3) {
            return 1
        }
        val leftNodes: MutableList<Int> = ArrayList()
        val rightNodes: MutableList<Int> = ArrayList()
        for (i in 1 until m) {
            if (nums[i] < nums[0]) {
                leftNodes.add(nums[i])
            } else {
                rightNodes.add(nums[i])
            }
        }
        val leftWays = dfs(leftNodes) % mod
        val rightWays = dfs(rightNodes) % mod
        return leftWays * rightWays % mod * table[m - 1][leftNodes.size] % mod
    }
}