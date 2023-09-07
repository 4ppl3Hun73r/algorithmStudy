package y2023.aug


// https://leetcode.com/problems/maximal-network-rank/
class Solution0818 {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val connectMap: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
        for (i in 0 until n) {
            connectMap[i] = mutableSetOf()
        }

        for (road in roads) {
            connectMap[road[0]]!!.add(road[1])
            connectMap[road[1]]!!.add(road[0])
        }

        var max = Int.MIN_VALUE
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val aSize = connectMap[i]!!.size
                val bSize = connectMap[j]!!.size
                val connectEachOther = connectMap[i]!!.contains(j)
                max = Math.max(max, aSize + bSize - if (connectEachOther) 1 else 0)
            }
        }

        return max
    }
}