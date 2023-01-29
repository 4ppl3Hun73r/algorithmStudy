package y2022.dec;

import model.TreeNode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class Solution1211 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // DP, DFS

        dfs(root);

        return max;
    }


    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int val = node.val;
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        max = Math.max(max, Math.max(val, Math.max(val + leftMax, Math.max(val + rightMax, val + leftMax + rightMax))));

        return Math.max(val, Math.max(val + leftMax, val + rightMax));
    }
}
