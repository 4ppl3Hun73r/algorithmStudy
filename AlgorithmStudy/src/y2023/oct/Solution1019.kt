package y2023.oct

// https://leetcode.com/problems/backspace-string-compare/description/?envType=daily-question&envId=2023-10-19
class Solution1019 {
    fun backspaceCompare(s: String, t: String): Boolean {
        var sPos = s.length - 1
        var tPos = t.length - 1

        var sBackspace = 0
        var tBackspace = 0
        while (sPos >= 0 || tPos >= 0) {
            while (sPos >= 0) {
                if (s[sPos] == '#') {
                    sBackspace++
                    sPos--
                } else if (sBackspace > 0) {
                    sBackspace--
                    sPos--
                } else {
                    break
                }
            }
            while (tPos >= 0) {
                if (t[tPos] == '#') {
                    tBackspace++
                    tPos--
                } else if (tBackspace > 0) {
                    tBackspace--
                    tPos--
                } else {
                    break
                }
            }

            if (sPos >= 0 && tPos >= 0 && s[sPos] != t[tPos]) {
                return false
            }

            if ((sPos >= 0) != (tPos >= 0)) {
                return false
            }

            sPos --
            tPos --
        }

        return true
    }




}