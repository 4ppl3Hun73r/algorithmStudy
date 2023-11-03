package y2023.oct

// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/
class Solution1007 {
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        var dp = Array<LongArray>(m + 1) {
            LongArray(k + 1)
        }
        var prefix = Array<LongArray>(m + 1) {
            LongArray(k + 1)
        }
        var prevDp = Array<LongArray>(m + 1) {
            LongArray(k + 1)
        }
        var prevPrefix = Array<LongArray>(m + 1) {
            LongArray(k + 1)
        }
        val mod = (1e9 + 7).toInt()

        for (num in 1 .. m) {
            dp[num][1] = 1
        }

        for (i in 1 .. n) {
            if (i > 1) {
                dp = Array<LongArray>(m + 1) {
                    LongArray(k + 1)
                }
            }
            prefix = Array<LongArray>(m + 1) {
                LongArray(k + 1)
            }

            for (maxNum in 1 .. m) {
                for (cost in 1 .. k) {
                    var ans = (maxNum * prevDp[maxNum][cost]) % mod
                    ans = (ans + prevPrefix[maxNum - 1][cost - 1]) % mod
                    dp[maxNum][cost] += ans
                    dp[maxNum][cost] = dp[maxNum][cost] % mod

                    prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost])
                    prefix[maxNum][cost] = prefix[maxNum][cost] % mod
                }
            }

            prevDp = dp
            prevPrefix = prefix
        }

        return prefix[m][k].toInt()
    }
}