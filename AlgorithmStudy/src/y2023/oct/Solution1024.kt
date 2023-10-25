package y2023.oct

import model.TreeNode
import java.util.*

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/?envType=daily-question&envId=2023-10-24
class Solution1024 {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }
        val queue:Queue<TreeNode> = LinkedList()
        val ans = mutableListOf<Int>()

        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size

            var maxValue = Int.MIN_VALUE
            for (i in 0 until size) {
                val node = queue.poll()
                maxValue = Math.max(maxValue, node.`val`)

                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            ans.add(maxValue)
        }

        return ans
    }
}