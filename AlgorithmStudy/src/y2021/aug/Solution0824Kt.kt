package y2021.aug

import java.util.*

class Solution0824Kt {
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        private lateinit var inputRoot: TreeNodeKt

        fun findTarget(root: TreeNodeKt?, k: Int): Boolean {
            if (root == null) return false
            inputRoot = root
            return check(inputRoot, k)
        }

        private fun check(root: TreeNodeKt?, k: Int): Boolean {
            if (root == null) return false

            var result = false

            val target = k - root.`val`
            result = find(target, inputRoot, root)

            return result || check(root.left, k) || check(root.right, k)
        }

        private fun find(target: Int, root: TreeNodeKt?, current: TreeNodeKt): Boolean {
            return when {
                root == null -> false
                root !== current && root.`val` == target -> true
                root.`val` < target -> find(target, root.right, current)
                else -> find(target, root.left, current)
            }
        }
    }

    data class Input(private val root: String, private val k: Int) {
        val rootNode: TreeNodeKt? = root.toTreeNode()
        val target get() = k
    }
}


fun main() {
    listOf(
        Solution0824Kt.Input(root = "[5,3,6,2,4,null,7]", k = 9),
        Solution0824Kt.Input("[5,3,6,2,4,null,7]", k = 28),
        Solution0824Kt.Input("[2,1,3]", k = 4),
        Solution0824Kt.Input("[2,1,3]", k = 1),
        Solution0824Kt.Input("[2,1,3]", k = 3)
    ).forEach {
        println(Solution0824Kt.Solution().findTarget(it.rootNode, it.target))
    }
}


fun String.toTreeNode(): TreeNodeKt? = TreeNodeKt.deserialize(this)


class TreeNodeKt(var `val`: Int) {
    var left: TreeNodeKt? = null
    var right: TreeNodeKt? = null

    companion object {
        /**
         * @param arrayString example: [1,2,null,3,4,5]
         */
        fun deserialize(arrayString: String): TreeNodeKt? {
            val nodes = arrayString
                    .removeSurrounding("[", "]")
                    .split(",")
                    .map {
                        when (it) {
                            "" -> null // case "[]"
                            "null" -> null
                            else -> TreeNodeKt(it.toInt())
                        }
                    }

            var childIndex = 1
            for (node in nodes) {
                node?.let {
                    it.left = if (childIndex < nodes.size) nodes[childIndex++] else null
                    it.right = if (childIndex < nodes.size) nodes[childIndex++] else null
                }
            }

            return nodes.first()
        }
    }

    private fun serialize(): String {
        val list = mutableListOf<Int?>()

        val queue: Queue<TreeNodeKt> = LinkedList()
        queue.offer(this)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            list.add(node?.`val`)

            node?.let {
                queue.offer(it.left)
                queue.offer(it.right)
            }
        }

        return list
                .dropLastWhile { it == null }
                .joinToString(separator = ",", prefix = "[", postfix = "]") { it.toString() }
    }

    override fun toString(): String {
        return serialize()
    }
}


