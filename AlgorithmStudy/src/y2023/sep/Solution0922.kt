package y2023.sep

// https://leetcode.com/problems/is-subsequence/?envType=daily-question&envId=2023-09-22
class Solution0922 {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var idx = 0

        for (ch in t) {
            if (ch == s[idx]) {
                idx++
            }
            if (idx == s.length) {
                return true
            }
        }

        return false
    }
}