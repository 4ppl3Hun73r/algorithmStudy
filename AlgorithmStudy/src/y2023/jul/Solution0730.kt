package y2023.jul

// https://leetcode.com/problems/strange-printer/
class Solution0730 {
    fun strangePrinter(s: String): Int {

        /*
        S 문자를 찍기 위해서 몇번이나 프린터 해야 하는가?

        프린터는 연속된 문자를 한번에 찍을 수 있음

        aaabbb
        1. aaa
        2.    bbb

        aba
        1. aaa
        2.  b

         */

        val n = s.length
        val dp = Array(n) {
            IntArray(n) {
                0
            }
        }
        for (len in 1..n) {
            for (left in 0..(n - len)) {
                val right = left + len - 1
                var j = -1
                dp[left][right] = n
                for (i in left until right) {
                    if (s[i] != s[right] && j == -1) {
                        j = i
                    }
                    if (j != -1) {
                        dp[left][right] = Math.min(dp[left][right], 1 + dp[j][i] + dp[i + 1][right])
                    }
                }

                if (j == -1) {
                    dp[left][right] = 0
                }
            }
        }

        return dp[0][n - 1] + 1

    }
}