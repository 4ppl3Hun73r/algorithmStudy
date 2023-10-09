package y2023.sep

import java.util.*

// https://leetcode.com/problems/reconstruct-itinerary/?envType=daily-question&envId=2023-09-14
class Solution0914 {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val graph = mutableMapOf<String, PriorityQueue<String>>()

        for (ticket in tickets) {
            if (graph[ticket[0]] == null) {
                graph[ticket[0]] = PriorityQueue()
            }
            graph[ticket[0]]!!.add(ticket[1])
        }

        val result = LinkedList<String>()

        dfs("JFK", graph, result)
        return result
    }

    private fun dfs(airport: String, graph: MutableMap<String, PriorityQueue<String>>, result: LinkedList<String>) {
        val nextAirport = graph[airport]
        while (nextAirport != null && nextAirport.isNotEmpty()) {
            dfs(nextAirport.poll(), graph, result)
        }
        result.addFirst(airport)
    }
}

fun main() {
    val s = Solution0914()

    println(s.findItinerary(
            listOf(
                    listOf("MUC","LHR"),
                    listOf("JFK","MUC"),
                    listOf("SFO","SJC"),
                    listOf("LHR","SFO")
            )
    ))
}