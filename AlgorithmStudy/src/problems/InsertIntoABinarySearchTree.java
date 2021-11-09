package problems;

import model.TreeNode;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        insertNode(root, val);

        return root;
    }

    private void insertNode(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insertNode(node.left, val);
            }
        }

        if (node.val < val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insertNode(node.right, val);
            }
        }
    }
}
