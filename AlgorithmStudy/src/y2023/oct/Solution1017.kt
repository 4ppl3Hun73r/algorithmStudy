package y2023.oct

import java.util.*

// https://leetcode.com/problems/validate-binary-tree-nodes/description/?envType=daily-question&envId=2023-10-17
class Solution1017 {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        // binay tree 일때 true
        val root = findRoot(n, leftChild, rightChild)
        if (root == -1) {
            return false
        }

        val seen = mutableSetOf<Int>()
        val queue: Queue<Int> = LinkedList()
        seen.add(root)
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            val children = intArrayOf(leftChild[node], rightChild[node])

            for (child in children) {
                if (child != -1) {
                    if (seen.contains(child)) {
                        return false
                    }
                    queue.offer(child)
                    seen.add(child)
                }
            }
        }

        return seen.size == n
    }

    fun findRoot(n: Int, leftChild: IntArray, rightChild: IntArray): Int {
        val children = mutableSetOf<Int>()
        for (left in leftChild) {
            children.add(left)
        }
        for (right in rightChild) {
            children.add(right)
        }

        for (i in 0 until n) {
            if (!children.contains(i)) {
                return i
            }
        }
        return -1
    }
}