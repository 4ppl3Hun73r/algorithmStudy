package y2023.jul

import model.TreeNode
import java.util.*

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
class Solution0710 {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        //      3
        // 9        20
        //      15      7
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var depth = 0
        while(queue.isNotEmpty()) {
            val size = queue.size;
            depth++

            for(i in 0 until size) {
                val node = queue.poll()

                if (node.left == null && node.right == null) {
                    return depth
                }
                node.left?.let {
                    queue.offer(node.left)
                }

                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }

        return depth
    }
}