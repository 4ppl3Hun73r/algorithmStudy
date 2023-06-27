package y2023.jun

import model.TreeNode
import java.util.*

//  https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
class Solution0615 {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) {
            return 1
        }

        var level = 0
        var maxValue = Int.MIN_VALUE
        var maxLevel = 1
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while(!queue.isEmpty()) {
            level++
            val size = queue.size
            var value = 0

            with(queue) {
                repeat(size) {
                    val node = poll()
                    value += node.`val`
                    node.left ?.let {
                        add(it)
                    }
                    node.right?.let {
                        add(it)
                    }
                }
            }
//            for(i in 0 until size) {
//                val node = queue.poll()
//                value += node.`val`
//
//                if(node.left != null)
//                    queue.add(node.left)
//                if(node.right != null)
//                    queue.add(node.right)
//            }


            if (maxValue < value) {
                maxValue = value
                maxLevel = level
            }
        }

        return maxLevel
    }
}