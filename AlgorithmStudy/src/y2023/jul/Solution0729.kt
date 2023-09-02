package y2023.jul

// https://leetcode.com/problems/soup-servings/
class Solution0729 {
    fun soupServings(n: Int): Double {
        /*
         Serve 100 ml of soup A and 0 ml of soup B,
         Serve 75 ml of soup A and 25 ml of soup B,
         Serve 50 ml of soup A and 50 ml of soup B, and
         Serve 25 ml of soup A and 75 ml of soup B.

         n = 50

         50 / 50 이 될 확률 1/4 -> 0.25
         */

        val serve = Math.ceil(n.toDouble() / 25.0).toInt()
        val memo = mutableMapOf<Int, MutableMap<Int, Double>>()

        for (i in 1 .. serve) {
            if (recv(i, i, memo) > 1 - 1e-5) {
                return 1.0
            }
        }

        return recv(serve, serve, memo)
    }

    private fun recv(i: Int, j: Int, memo: MutableMap<Int, MutableMap<Int, Double>>): Double {
        if ( i <= 0 && j <= 0) {
            return 0.5
        }
        if (i <= 0) {
            return 1.0
        }
        if (j <= 0) {
            return 0.0
        }
        if(memo.containsKey(i) && memo[i]!!.containsKey(j)) {
            return memo[i]!![j]!!
        }

        val result = (recv(i - 4, j, memo) + recv(i - 3, j - 1, memo)
                + recv(i - 2, j - 2, memo) + recv(i - 1, j - 3, memo)) / 4.0

        if (memo[i] == null) {
            memo[i] = mutableMapOf()
        }
        memo[i]!![j] = result

        return result
    }
}