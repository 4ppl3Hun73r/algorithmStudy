package y2023.jul

// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
class Solution0726 {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        var left = 1
        var right = 10000000
        var result = -1

        fun checkTime(speed: Int): Double {
            var time = 0.0
            dist.forEachIndexed { index, d ->
                val tempTime = d.toDouble() / speed.toDouble()
                time += if (index == dist.size - 1) tempTime else Math.ceil(tempTime)
            }
            return time
        }

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (checkTime(mid) <= hour) {
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return result
    }
}