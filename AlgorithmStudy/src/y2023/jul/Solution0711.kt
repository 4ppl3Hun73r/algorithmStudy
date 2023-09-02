package y2023.jul

import model.TreeNode
import java.util.*

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
class Solution0711 {
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        if (root == null || target == null) {
            return listOf()
        }
        /*if ( k == 0 ) {
            return listOf(target.`val`)
        }*/
        // target Node 먼저 구하고
        val res = mutableListOf<Int>()
        val parentMap = mutableMapOf<TreeNode, TreeNode>()
        val visitedMap = mutableMapOf<TreeNode, Boolean>()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while(queue.isNotEmpty()) {
            val node = queue.poll()
            visitedMap[node] = false
            node.left?.let {
                parentMap[it] = node
                queue.offer(it)
            }
            node.right?.let {
                parentMap[it] = node
                queue.offer(it)
            }
        }

        queue.offer(target)
        visitedMap[target] = true
        var depth = 0
        while(queue.isNotEmpty()) {
            val size = queue.size

            if (depth == k) {
                while(queue.isNotEmpty()) {
                    res.add(queue.poll().`val`)
                }
                break
            }
            for(i in 0 until size) {
                val node = queue.poll()
                visitedMap[node] = true

                node.left?.let {
                    if(visitedMap[it] == false)
                        queue.offer(it)
                }

                node.right?.let {
                    if (visitedMap[it] == false) {
                        queue.offer(it)
                    }
                }

                parentMap[node]?.let {
                    if (visitedMap[it] == false) {
                        queue.offer(it)
                    }
                }
            }
            depth++

        }

        return res
    }
}
