package y2023.jul

// https://leetcode.com/problems/fair-distribution-of-cookies/
class Solution0701 {
    fun distributeCookies(cookies: IntArray, k: Int): Int {
        val distribute = IntArray(k)

        return dfs(0, distribute, cookies, k, k)
    }

    private fun dfs(i: Int, distribute: IntArray, cookies: IntArray, k: Int, _zeroCount: Int): Int {
        var zeroCount = _zeroCount
        if (cookies.size - i < zeroCount) {
            return Int.MAX_VALUE
        }

        if (i == cookies.size) {
            var unfairness = Int.MIN_VALUE
            for (value in distribute) {
                unfairness = unfairness.coerceAtLeast(value)
            }
            return unfairness
        }

        var answer = Int.MAX_VALUE
        for (j in 0 until k) {
            zeroCount -= if (distribute[j] == 0) 1 else 0
            distribute[j] += cookies[i]

            answer = answer.coerceAtMost(dfs(i + 1, distribute, cookies, k, zeroCount))
            distribute[j] -= cookies[i]
            zeroCount += if (distribute[j] == 0) 1 else 0
        }
        return answer
    }
}