package y2023.jun

import java.util.*

class Solution0603 {

    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val subMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for ( i in 0 until n ) {
            subMap[i] = mutableListOf()
        }

        manager.forEachIndexed { index, m ->
            if (m != -1) {
                subMap[m]?.add(index)
            }
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(headID to informTime[headID])
        var maxTime = 0
        while (queue.isNotEmpty()) {
            val (m, time) = queue.poll()

            maxTime = Math.max(maxTime, time)
            subMap[m]?.forEach { e ->
                if (informTime[e] != 0) {
                    queue.offer(e to time + informTime[e])
                }
            }
        }

        return maxTime
    }
}
