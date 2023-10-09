package y2023.sep

// https://leetcode.com/problems/find-the-difference/description/?envType=daily-question&envId=2023-09-25
class Solution0925 {
    fun findTheDifference(s: String, t: String): Char {
        val map = IntArray(26)

        for (c in s) {
            map[c - 'a']++
        }
        for (c in t) {
            map[c - 'a']--
        }

        for (i in 0 until 26) {
            if (map[i] != 0) {
                return 'a' + i
            }
        }

        return 'a'
    }
}