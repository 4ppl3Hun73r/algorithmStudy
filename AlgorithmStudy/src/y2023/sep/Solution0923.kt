package y2023.sep

// https://leetcode.com/problems/longest-string-chain/description/?envType=daily-question&envId=2023-09-23
class Solution0923 {

    val cache = mutableMapOf<Int, Int>()
    fun longestStrChain(words: Array<String>): Int {
        words.sortWith(Comparator.comparingInt { s -> s.length })
        var result = Int.MIN_VALUE
        for (i in 0 until words.size) {
            result = Math.max(helper(words, i), result)
        }

        return result
    }

    private fun helper(words: Array<String>, idx: Int): Int {
        if (cache.containsKey(idx)) {
            return cache[idx]!!
        }

        val word = words[idx]!!
        var chain = 1
        var nextChainLen = word.length + 1
        for (i in idx + 1 until words.size) {
            if (nextChainLen == words[i].length) {
                if (validation(word, words[i])) {
                    chain = Math.max(chain, helper(words, i) + 1)
                }
            } else if (words[i].length > nextChainLen) {
                break
            }
        }
        cache[idx] = chain

        return chain
    }

    private fun validation(word1: String, word2: String): Boolean {
        var w1Left = 0
        var w1Right = word1.length - 1

        var w2Left = 0
        var w2Right = word2.length - 1

        var skip = 0

        while (w2Left <= w2Right) {
            if (skip == 2) {
                break
            }
            if (word1[w1Left] != word2[w2Left]) {
                skip++
                w2Left++
                continue
            }
            if (word1[w1Right] != word2[w2Right]) {
                skip++
                w2Right--
                continue
            }
            w1Left++
            w2Left++
            w1Right--
            w2Right--
        }
        return skip != 2
    }
}