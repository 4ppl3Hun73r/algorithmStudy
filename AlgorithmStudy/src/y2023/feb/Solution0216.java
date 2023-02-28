package y2023.feb;

import model.TreeNode;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class Solution0216 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
    }
}
