package y2023.jul

// https://leetcode.com/problems/powx-n
class Solution0724 {
    fun myPow(x: Double, n: Int): Double {
        var x = x
        var n = n.toLong()

        if (n == 0L) {
            return 1.0
        }

        if (n < 0) {
            n *= -1
            x = 1.0 / x
        }

        var result = 1.0
        while ( n != 0L ) {
            if (n % 2L == 1L) {
                result *= x
                n -= 1
            }
            x *= x
            n /= 2
        }

        return result
    }
}