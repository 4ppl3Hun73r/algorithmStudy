package y2023.oct

// https://leetcode.com/problems/integer-break/?envType=daily-question&envId=2023-10-06
class Solution1006 {
    fun integerBreak(n: Int): Int {
        if (n <= 3) {
            return n - 1
        }

        if ( n % 3 == 0) {
            return Math.pow(3.0, (n / 3).toDouble()).toInt()
        }

        if (n % 3 == 1) {
            return Math.pow(3.0, (n / 3 - 1).toDouble()).toInt() * 4
        }

        return Math.pow(3.0, (n / 3).toDouble()).toInt() * 2
    }
}