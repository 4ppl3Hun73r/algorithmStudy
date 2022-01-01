package y2021.oct;

import model.TreeNode;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class Solution1013 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insertTree(root, preorder[i]);
        }

        return root;
    }

    private void insertTree(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insertTree(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insertTree(node.right, val);
            }
        }
    }

}
