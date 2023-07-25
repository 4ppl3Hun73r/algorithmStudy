package y2023.jul

// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
class Solution0707 {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        /*
          TTFF, tk = 2
          ^ ^
          TTTF, tk = 1

         */
        fun findAnswer(flipChar: Char): Int {
            var cnt = 0
            var size = 0
            var start = 0
            answerKey.forEachIndexed {index, c ->
                cnt += if (c == flipChar) 1 else 0
                while (cnt > k) {
                    cnt -= if (answerKey[start++] == flipChar) 1 else 0
                }
                size = size.coerceAtLeast(index - start + 1)
            }

            return size
        }

        return findAnswer('F').coerceAtLeast(findAnswer('T'))
    }
}

fun main() {
    val s  = Solution0707()

    println(s.maxConsecutiveAnswers("TTFF", 2))

}
