package y2023.jul

import model.TreeNode


// https://leetcode.com/problems/all-possible-full-binary-trees/
class Solution0723 {

    val cache = mutableMapOf<Int, List<TreeNode>>()

    fun allPossibleFBT(n: Int): List<TreeNode?> {
        if (n % 2 == 0) {
            return ArrayList()
        }

        if (n == 1) {
            return listOf(TreeNode())
        }

        if (cache.containsKey(n)) {
            return cache.get(n)!!
        }

        val res = mutableListOf<TreeNode>()
        for (i in 1 until n step 2) {
            val left = allPossibleFBT(i)
            val right = allPossibleFBT(n - i - 1)
            for (l in left) {
                for (r in right) {
                    val root = TreeNode(0, l, r)
                    res.add(root)
                }
            }
        }

        cache.put(n, res)
        return res
    }
}