package y2023.sep

// https://leetcode.com/problems/extra-characters-in-a-string/?envType=daily-question&envId=2023-09-02
class Solution0902 {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val memo = IntArray(s.length) { -1 }
        val dictionarySet = dictionary.toSet()

        return dfs(s, dictionarySet, memo, 0, s.length)
    }

    private fun dfs(s: String, dictionarySet: Set<String>, memo: IntArray, start: Int, end: Int): Int {
        // 0 부터 end 까지 minExtraChar 수
        if (start == end) {
            return 0
        }
        if (memo[start] != -1) {
            return memo[start]
        }

        var result = dfs(s, dictionarySet, memo, start + 1, end) + 1
        for (step in start until end) {
            val right = s.substring(start, step + 1)
            println(right)
            if (dictionarySet.contains(right)) {
                result = Math.min(result, dfs(s, dictionarySet, memo, step + 1, end))
            }
        }
        memo[start] = result

        return result
    }
}

fun main() {
    val s = Solution0902()
    println(s.minExtraChar("sayhelloworld", arrayOf("hello", "world")))
}
