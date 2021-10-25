package problems;

import model.TreeNode;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        return diff(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean diff(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) return false;

        return diff(root.left, subRoot.left) && diff(root.right, subRoot.right);
    }

}
