package y2023.jun

import model.TreeNode

// https://leetcode.com/problems/minimum-absolute-difference-in-bst/
class Solution0614 {

    fun getMinimumDifference(root: TreeNode?): Int {
        /*
        node 간의 최소 값을 반환
        그런데 tree 가 bst 로 되어 있어서
        inorder 탐색하면 asc 로 정렬 되어 있음
         */
        val list = mutableListOf<Int>()
        fun dfs(node: TreeNode?) {
            if (node == null) {
                return
            }
            dfs(node.left)
            list.add(node.`val`)
            dfs(node.right)
        }
        dfs(root)

        var minDiff = Int.MAX_VALUE
        for (i in 1 until list.size) {
            minDiff = Math.min(minDiff, list[i] - list[i - 1])
        }

        return minDiff
    }
}