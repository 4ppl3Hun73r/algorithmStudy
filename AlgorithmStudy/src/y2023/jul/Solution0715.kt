package y2023.jul

import java.util.*


// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
class Solution0715 {

    lateinit var dp: Array<IntArray>
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        Arrays.sort(events) { a: IntArray, b: IntArray -> a[0] - b[0] }
        val n = events.size
        dp = Array(k + 1) { IntArray(n) { - 1 } }
        return dfs(0, 0, -1, events, k)
    }

    private fun dfs(curIndex: Int, count: Int, prevEndingTime: Int, events: Array<IntArray>, k: Int): Int {
        if (curIndex == events.size || count == k) {
            return 0
        }
        if (prevEndingTime >= events[curIndex][0]) {
            return dfs(curIndex + 1, count, prevEndingTime, events, k)
        }
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex]
        }
        val ans = dfs(curIndex + 1, count, prevEndingTime, events, k)
                .coerceAtLeast(dfs(curIndex + 1, count + 1, events[curIndex][1], events, k) + events[curIndex][2])
        dp[count][curIndex] = ans
        return ans
    }


    fun maxValuePQFail(events: Array<IntArray>, k: Int): Int {

        val com = Comparator<IntArray> { a, b -> a[0] - b[0] }

        val pq = PriorityQueue<IntArray>(com)
        val pq2 = PriorityQueue<Int> { a, b -> b - a }

        events.forEach {
            pq.offer(it)
        }

            while (pq.isNotEmpty()) {
                var event = pq.poll()

                while (pq.isNotEmpty()) {
                    var nextEvent = pq.peek()
                    if (event[1] >= nextEvent[0]) {
                        nextEvent = pq.poll()
                        if (event[2] < nextEvent[2]) {
                            event = nextEvent
                        } else if (event[2] == nextEvent[2]){
                            if (nextEvent[1] < event[1]) {
                                event = nextEvent
                            }
                        }
                    } else {
                        break;
                    }
                }
                pq2.offer(event[2])
            }

        var ans = 0
        var k = k
        while (pq2.isNotEmpty() && k-- != 0) {
            ans += pq2.poll()
        }

        return ans
    }
}

fun main() {

    val s = Solution0715()

    println(s.maxValue(arrayOf(intArrayOf(1, 2, 4), intArrayOf(3, 4, 3), intArrayOf(2, 3, 10)), 2))

}