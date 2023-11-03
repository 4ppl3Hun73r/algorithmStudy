package y2023.oct

// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/?envType=daily-question&envId=2023-10-01
class Solution1001 {
    fun reverseWords(s: String): String {
        val sb = StringBuilder()
        val sb2 = StringBuilder()

        for (c in s) {
            if (c == ' ') {
                sb.append(sb2.reverse().toString())
                sb.append(' ')
                sb2.clear()
            } else {
                sb2.append(c)
            }
        }
        sb.append(sb2.reverse().toString())

        return sb.toString()
    }
}