package y2023.aug


// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class Solution0803 {
    fun letterCombinations(digits: String): List<String> {
        /*
        1
        2 abc
        3 def
        4 ghi
        5 jkl
        6 mno
        7 pqrs
        8 tuv
        9 wxyz
        0
         */
        if (digits.isEmpty()) {
            return ArrayList()
        }
        val phone = arrayOf(charArrayOf(), charArrayOf(), charArrayOf('a', 'b', 'c'), charArrayOf('d', 'e', 'f'), charArrayOf('g', 'h', 'i'), charArrayOf('j', 'k', 'l'), charArrayOf('m', 'n', 'o'), charArrayOf('p', 'q', 'r', 's'), charArrayOf('t', 'u', 'v'), charArrayOf('w', 'x', 'y', 'z'))
        val ans: MutableList<String> = mutableListOf()
        combination(StringBuilder(), phone, digits, 0, ans)
        return ans
    }

    private fun combination(sb: StringBuilder, phone: Array<CharArray>, digits: String, step: Int, ans: MutableList<String>) {
        if (step >= digits.length) {
            ans.add(sb.toString())
            return
        }
        val digit = Character.getNumericValue(digits[step])
        for (i in phone[digit].indices) {
            sb.append(phone[digit][i])
            combination(sb, phone, digits, step + 1, ans)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}