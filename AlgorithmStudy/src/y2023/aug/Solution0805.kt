package y2023.aug

import model.TreeNode


// https://leetcode.com/problems/unique-binary-search-trees-ii/
class Solution0805 {
    fun generateTrees(n: Int): List<TreeNode?> {
        return dfs(1, n)

    }

    fun dfs(start: Int, end: Int): List<TreeNode?> {
        val result = mutableListOf<TreeNode?>()

        if (start > end) {
            result.add(null)
            return result
        }

        if (start == end) {
            result.add(TreeNode(start))
            return result
        }

        for (i in start .. end) {
            val left = dfs(start, i - 1)
            val right = dfs(i + 1, end)

            for (l in left) {
                for (r in right) {
                    val root = TreeNode(i)
                    root.left = l
                    root.right = r
                    result.add(root)
                }
            }
        }
        return result
    }
}