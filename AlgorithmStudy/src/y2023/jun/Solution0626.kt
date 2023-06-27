package y2023.jun

import java.util.*

// https://leetcode.com/problems/total-cost-to-hire-k-workers/
class Solution0626 {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        /*
        [3,2,7,7,1,2]

        1 회 면접에서 3/l, 2/l, 1/r, 2/r -> 1/r
        2 회 면접에서 3/l, 2/l, 2/r, 7/l -> 2/l

        leftPos = 2
        left = [3,2]

        rightPos = 3
        right = [1,2]

        pq = [1/r, 2/r, 2/l, 3/l]
         */
        class Hire(
                val cost: Int,
                val idx: Int,
                val left: Boolean
        )

        val comparator = Comparator<Hire> {
            o1, o2 ->
            if (o1.cost == o2.cost) o1.idx - o2.idx
            else o1.cost - o2.cost
        }
        val pq = PriorityQueue(comparator)

        var left = 0

        for (i in 0 until candidates) {
            pq.offer(Hire(costs[left], left, true))
            left ++
        }
        var right = costs.size - 1 - candidates
        for (i in Math.max(candidates, costs.size - candidates) until costs.size) {
            pq.offer(Hire(costs[i], i, false))
        }

        var cost: Long = 0
        for (i in 0 until k) {
            val p = pq.poll()
            cost += p.cost.toLong()

            if (left <= right) {
                if (p.left) {
                    pq.offer(Hire(costs[left], left, true))
                    left++
                } else {
                    pq.offer(Hire(costs[right], right, false))
                    right --
                }
            }

        }

        return cost
    }
}

fun main() {
    val s = Solution0626()

    println(s.totalCost(intArrayOf(17,12,10,2,7,2,11,20,8), 3, 4))
}