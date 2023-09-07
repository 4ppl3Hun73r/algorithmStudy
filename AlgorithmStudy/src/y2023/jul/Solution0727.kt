package y2023.jul

// https://leetcode.com/problems/maximum-running-time-of-n-computers/
class Solution0727 {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        var allSum: Long = 0L
        for (element in batteries) {
            allSum += element.toLong()
        }

        var left = 1L
        var right = allSum / n.toLong()

        while (left < right) {
            val mid = right - (right - left) / 2
            var extra = 0L

            batteries.forEach {
                extra += Math.min(it.toLong(), mid)
            }

            if (extra >= (n.toLong() * mid)) {
                left = mid
            } else {
                right = mid - 1
            }
        }

        return left
    }
}