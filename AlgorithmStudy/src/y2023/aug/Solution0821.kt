package y2023.aug

// https://leetcode.com/problems/repeated-substring-pattern/
class Solution0821 {
    fun repeatedSubstringPattern(s: String): Boolean {
        val twoS = s + s
        return twoS.substring(1, twoS.length - 1).contains(s)
    }
}