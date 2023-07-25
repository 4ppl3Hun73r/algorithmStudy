package y2023.jun

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/path-with-maximum-probability/
class Solution0628 {

    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        val graph = Array(n) {
            mutableSetOf<Pair<Int, Double>>()
        }

        edges.forEachIndexed { index, edge ->
            graph[edge[0]].add(edge[1] to succProb[index])
            graph[edge[1]].add(edge[0] to succProb[index])
        }
        val maxProbs = Array(n) {
            0.0
        }
        val queue:Queue<Int> = LinkedList()
        queue.offer(start)
        maxProbs[start] = 1.0
        while (queue.isNotEmpty()) {
            val edge = queue.poll()
            for (pair in graph[edge]) {
                val nextEdge = pair.first
                val nextProb = pair.second

                if (maxProbs[edge] * nextProb > maxProbs[nextEdge]) {
                    maxProbs[nextEdge] = maxProbs[edge] * nextProb
                    queue.offer(nextEdge)
                }
            }
        }

        // dfs(graph, visited, 1.0, start, end)

        return maxProbs[end]
    }


    // timelimit
    fun dfs(graph: Array<MutableSet<Pair<Int, Double>>>, visited: Array<Double>, prob: Double, start: Int, end: Int) {
        if (start == end) {
            //maxProb = maxProb.coerceAtLeast(prob)
            return
        }

        visited[start] = prob
        graph[start].forEach {
            if (visited[it.first] != -1.0) {
                if (prob * it.second > visited[it.first]) {
                    visited[it.first] = prob * it.second
                    dfs(graph, visited, prob * it.second, it.first, end)
                }
            } else {
                visited[it.first] = prob * it.second
                dfs(graph, visited, prob * it.second, it.first, end)
            }
        }
    }
}

fun main() {
    val s = Solution0628()
    println(s.maxProbability(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2)), doubleArrayOf(0.5, 0.5, 0.3), 0, 2))
}