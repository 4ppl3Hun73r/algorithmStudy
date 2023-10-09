package y2023.sep

import java.util.*

// https://leetcode.com/problems/remove-duplicate-letters/?envType=daily-question&envId=2023-09-26
class Solution0926 {
    fun removeDuplicateLetters(s: String): String {
        val alphabet = IntArray(26)
        for (c in s) {
            alphabet[c - 'a']++
        }
        val map = BooleanArray(26)
        val stack = Stack<Char>()
        for (i in 0 until s.length) {
            val c = s[i]
            alphabet[c - 'a']--
            if (map[c - 'a']) {
                continue
            }
            while (!stack.isEmpty() && alphabet[stack.peek() - 'a'] != 0 && c < stack.peek()) {
                val top = stack.pop()
                map[top - 'a'] = false
            }
            stack.push(c)
            map[c - 'a'] = true
        }


        val sb = StringBuilder()
        for (c in stack) {
            sb.append(c)
        }
        return sb.toString()
    }
}