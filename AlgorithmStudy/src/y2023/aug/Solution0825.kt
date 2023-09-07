package y2023.aug

// https://leetcode.com/problems/interleaving-string/
class Solution0825 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        /*
        s1 과 s2 를 가지고 s3를 만들기

        규칙
        s = s1 + s2 + s3 .. + sn
        t = t1 + t2 + t3 .. + tm
        |n-m| <= 1

        s1 + t1 + s2 + t2 ..
        t1 + s1 + t2 + s2 ..

         dp[1][0] = s1[i] == t[0] => T
         dp[0][1] = s2[j] == t[0] => F
         dp[1][1] = (dp[1][0] && t[1] == s2[1]) || (dp[0][1] && t[1] == s1[1])
         dp....
         */
        if (s3.length != s1.length + s2.length) {
            return false
        }

        val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) }

        for (i in 0..s1.length) {
            for (j in 0..s2.length) {
                val k = i + j - 1
                if (i == 0 && j == 0) {
                    dp[i][j] = true
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2[j - 1] == s3[k]
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1[i - 1] == s3[k]
                } else {
                    dp[i][j] = dp[i - 1][j] && s1[i - 1] == s3[k] || dp[i][j - 1] && s2[j - 1] == s3[k]
                }
            }
        }


        return dp[s1.length][s2.length]
    }
}