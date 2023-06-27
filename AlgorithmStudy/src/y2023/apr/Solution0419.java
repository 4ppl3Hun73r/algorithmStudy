package y2023.apr;

import model.TreeNode;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
public class Solution0419 {
    public int longestZigZag(TreeNode root) {

        return Math.max(longest(root.left, true, 0), longest(root.right, false, 0));
    }

    private int longest(TreeNode node, boolean left, int step) {
        if (node == null) {
            return step;
        }

        if (left) {
            return Math.max(longest(node.left, true, 0), longest(node.right, false, step + 1));
        }
        return Math.max(longest(node.left, true, step + 1), longest(node.right, false, 0));
    }
}
