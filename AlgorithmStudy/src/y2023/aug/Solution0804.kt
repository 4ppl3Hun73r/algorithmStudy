package y2023.aug

// https://leetcode.com/problems/word-break/
class Solution0804 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val dict = mutableSetOf<String>()
        wordDict.map { dict.add(it) }

        val dp = BooleanArray(s.length + 1) { false }
        dp[0] = true
        for( i in 1..s.length) {
            for ( j in 0 until i) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true
                }
            }
        }
        return dp[s.length]

    }
}