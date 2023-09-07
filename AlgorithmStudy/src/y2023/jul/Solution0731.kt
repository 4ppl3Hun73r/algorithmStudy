package y2023.jul

// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
class Solution0731 {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        if (s1.length < s2.length) {
            return minimumDeleteSum(s2, s1)
        }

        val m = s1.length
        val n = s2.length
        val row = IntArray(n + 1)  // n이 작음

        for (j in 1..n) {
            row[j] = row[j - 1] + s2[j - 1].code
        }

        for (i in 1..m) {
            var diag = row[0]
            row[0] += s1[i - 1].code
            for (j in 1..n) {
                val answer: Int = if (s1[i - 1] == s2[j - 1]) {
                    diag
                } else {
                    Math.min(
                            s1[i - 1].code + row[j],
                            s2[j - 1].code + row[j - 1]
                    )
                }

                diag = row[j]
                row[j] = answer
            }
        }

        return row[n]
    }
}