package y2023.jul


// https://leetcode.com/problems/find-eventual-safe-states/
class Solution0712 {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val nodeCnt: Int = graph.size

        val safeNode = mutableSetOf<Int>()
        val visited = mutableSetOf<Int>()
        for (i in 0 until nodeCnt) {
            if (!safeNode.contains(i) || !visited.contains(i)) {
                dfs(i, graph, visited, safeNode)
            }
        }

        val ans = mutableListOf<Int>()
        for (i in 0 until nodeCnt) {
            if (safeNode.contains(i)) {
                ans.add(i)
            }
        }

        return ans
    }

    private fun dfs(node: Int, graph: Array<IntArray>, visited: MutableSet<Int>, safeNode: MutableSet<Int>): Boolean {
        if (visited.contains(node)) {
            return safeNode.contains(node)
        }

        visited.add(node)
        val nextNodes = graph[node]
        var isSafe = true
        for (i in nextNodes.indices) {
            val nextNode = nextNodes[i]
            if (safeNode.contains(nextNode)) {
                continue
            }
            isSafe = if (nextNode == node) {
                false
            } else {
                dfs(nextNode, graph, visited, safeNode)
            }
            if (!isSafe) {
                break
            }
        }
        if (isSafe) {
            safeNode.add(node)
        }
        return isSafe
    }
}