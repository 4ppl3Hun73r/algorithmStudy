package y2023.aug

import java.util.*

// https://leetcode.com/problems/reorganize-string/
class Solution0823 {
    fun reorganizeString(s: String): String {
        if (s.length == 1) {
            return s
        }

        val comparator = Comparator<Pair<Char, Int>> {
            o1, o2 ->
            o2.second - o1.second
        }
        val pq = PriorityQueue<Pair<Char, Int>>(comparator)
        for(e in s.groupingBy { it }.eachCount().entries) {
            pq.offer(e.toPair())
        }

        val sb = StringBuilder()
        while (pq.size > 1) {
            val f = pq.poll()
            val se = pq.poll()

            sb.append(f.first)
            sb.append(se.first)

            if (f.second - 1 != 0) {
                pq.offer(f.first to f.second - 1)
            }
            if (se.second - 1 != 0) {
                pq.offer(se.first to se.second - 1)
            }
        }

        if (pq.size == 1) {
            val l = pq.poll()

            if (l.second != 1) {
                return ""
            }

            if (l.first == sb.last()) {
                return ""
            }

            sb.append(l.first)
        }


        return sb.toString()
    }
}