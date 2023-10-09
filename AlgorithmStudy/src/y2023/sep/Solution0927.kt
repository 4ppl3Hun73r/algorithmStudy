package y2023.sep


// https://leetcode.com/problems/decoded-string-at-index/?envType=daily-question&envId=2023-09-27
class Solution0927 {
    fun decodeAtIndex(s: String, k: Int): String {
        var i: Int = 0
        var N: Long = 0
        var K: Long = k.toLong()
        while (N < K) {
            N = if (Character.isDigit(s[i])) N * (s[i] - '0') else N + 1
            i++
        }
        i--
        while (i > 0) {
            if (Character.isDigit(s[i])) {
                N /= s[i] - '0'
                K %= N.toInt()
            } else {
                if (K % N == 0L) {
                    break
                }
                N--
            }
            i--
        }
        return s[i].toString()
    }
}