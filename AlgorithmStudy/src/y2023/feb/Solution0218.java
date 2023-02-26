package y2023.feb;

import model.TreeNode;

// https://leetcode.com/problems/invert-binary-tree/
public class Solution0218 {

    public TreeNode invertTree(TreeNode root) {
        swapTree(root);
        return root;
    }

    private void swapTree(TreeNode node) {
        if (node == null) {
            return ;
        }

        swapTree(node.left);
        swapTree(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
