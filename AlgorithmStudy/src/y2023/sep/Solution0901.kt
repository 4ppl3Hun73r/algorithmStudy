package y2023.sep

// https://leetcode.com/problems/counting-bits/?envType=daily-question&envId=2023-09-01
class Solution0901 {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)
        result[0] = 0

        if (n > 0) {
            result[1] = 1
        }

        var init = 2
        var prev = 1
        for (i in 2 .. n) {
            if (i == init) {
                init *= 2
                prev *= 2
            }
            result[i] = result[i - prev] + 1
        }

        return result
    }
}