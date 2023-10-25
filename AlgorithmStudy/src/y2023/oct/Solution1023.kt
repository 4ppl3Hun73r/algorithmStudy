package y2023.oct

// https://leetcode.com/problems/power-of-four/?envType=daily-question&envId=2023-10-23
class Solution1023 {
    fun isPowerOfFour(n: Int): Boolean {
        if (n < 1) {
            return false
        }

        val powerOfFourSet = mutableSetOf<Long>()
        var pow = 0L
        var i = 0.0
        while (pow < n) {
            pow = Math.pow(4.0, i).toLong()
            powerOfFourSet.add(pow)
            i++
        }

        return powerOfFourSet.contains(n.toLong())

    }
}