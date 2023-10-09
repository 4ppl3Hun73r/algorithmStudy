package y2023.sep

import java.util.*

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/?envType=daily-question&envId=2023-09-11
class Solution0911 {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val map = TreeMap<Int, MutableList<Int>>()
        groupSizes.forEachIndexed { index, i ->
            if (map[i] == null) {
                map[i] = mutableListOf()
            }
            map[i]!!.add(index)
        }
        val result = mutableListOf<List<Int>>()

        map.forEach { (t, u) ->
            for (i in 0 until u.size / t) {
                val sub = mutableListOf<Int>()
                for (j in 0 until t) {
                    sub.add(u[i * t + j])
                }
                result.add(sub)
            }
        }

        return result
    }
}