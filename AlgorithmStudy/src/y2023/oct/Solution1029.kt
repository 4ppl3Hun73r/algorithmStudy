package y2023.oct

// https://leetcode.com/problems/poor-pigs/submissions/766392413/?envType=daily-question&envId=2023-10-29
class Solution1029 {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val round = (minutesToTest / minutesToDie).toDouble()

        var i = 0.0
        while (Math.pow(round + 1, i) < buckets) {
            i++
        }

        return i.toInt()
    }
}