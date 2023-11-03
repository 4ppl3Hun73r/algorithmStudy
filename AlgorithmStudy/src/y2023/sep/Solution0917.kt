package y2023.sep

import java.util.*


// https://leetcode.com/problems/shortest-path-visiting-all-nodes/
class Solution0917 {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val len = graph.size
        if (len == 1) {
            return 0
        }

        val nodeVisitedSet = mutableMapOf<Int, MutableSet<Int>>()
        val queue: Queue<Node> = LinkedList()

        for (i in 0 until len) {
            val visited = 1 shl i
            queue.add(Node(i, visited))
            nodeVisitedSet[i] = mutableSetOf()
        }
        var ans = 0
        var findVisitedMask = (1 shl len) - 1
        while (queue.isNotEmpty()) {
            val size = queue.size
            ans ++
            for (i in 0 until size) {
                val node = queue.poll()
                val g = graph[node.n]
                for (j in 0 until g.size) {
                    val nextNode = g[j]
                    val newVisited = node.visited or (1 shl nextNode)
                    if (newVisited == findVisitedMask) {
                        return ans
                    }
                    if (nodeVisitedSet[nextNode]!!.contains(newVisited)) {
                        continue
                    }
                    nodeVisitedSet[nextNode]!!.add(newVisited)
                    queue.add(Node(nextNode, newVisited))
                }
            }
        }

        return ans

    }

    data class Node(val n: Int, val visited: Int)
}