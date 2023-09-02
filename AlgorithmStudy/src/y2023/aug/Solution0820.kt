package y2023.aug

import java.util.*

// https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
class Solution0820 {
    fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {
        /*

        0 | -1 |
        1 | -1 | 6
        2 |  1 | 5
        3 |  0 | 6
        4 |  0 | 3,6
        5 |  1 |
        6 |  0 |
        7 | -1 |


        group -1 : 0, 1, 7,
        group 0 : 3, 4, 6
        group 1 : 2, 5

        [6, 3, 4, 5, 2, 0, 1, 7] OK
        [6, 3, 4, 1, 5, 2, 0, 7] OK
         */

        var groupId = m
        for (i in 0 until n) {
            if (group[i] == -1) {
                group[i] = groupId++
            }
        }

        val itemGraph = mutableMapOf<Int, MutableList<Int>>()
        val itemIndegree = IntArray(n)
        for (i in 0 until n) {
            itemGraph[i] = mutableListOf()
        }

        val groupGraph = mutableMapOf<Int, MutableList<Int>>()
        val groupIndegree = IntArray(groupId)
        for (i in 0 until groupId) {
            groupGraph[i] = mutableListOf()
        }

        for (curr in 0 until n) {
            for (prev in beforeItems[curr]) {
                itemGraph[prev]!!.add(curr)
                itemIndegree[curr]++

                if (group[curr] != group[prev]) {
                    groupGraph[group[prev]]!!.add(group[curr])
                    groupIndegree[group[curr]]++
                }
            }
        }

        val itemOrder = topologicalSort(itemGraph, itemIndegree)
        val groupOrder = topologicalSort(groupGraph, groupIndegree)

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return IntArray(0)
        }

        val orderedGroups = mutableMapOf<Int, MutableList<Int>>()
        for (item in itemOrder) {
            orderedGroups.computeIfAbsent(group[item]) {
                mutableListOf()
            }.add(item)
        }

        val answerList = mutableListOf<Int>()
        for (groupIndex in groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, mutableListOf()))
        }

        return answerList.toIntArray()
    }

    private fun topologicalSort(graph: MutableMap<Int, MutableList<Int>>, indegree: IntArray): List<Int> {
        val visited = mutableListOf<Int>()
        val stack = Stack<Int>()
        for (key in graph.keys) {
            if (indegree[key] == 0)  {
                stack.push(key)
            }
        }

        while (stack.isNotEmpty()) {
            val curr = stack.pop()
            visited.add(curr)

            for (prev in graph[curr]!!) {
                indegree[prev]--
                if(indegree[prev] == 0) {
                    stack.push(prev)
                }
            }
        }

        return if (visited.size == graph.size) visited else mutableListOf()
    }
}