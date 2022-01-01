package y2021.oct;


import model.TreeNode;

// https://leetcode.com/problems/invert-binary-tree/
public class Solution1026 {
    public TreeNode invertTree(TreeNode root) {
        //
        swap(root);

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempRight = invertTree2(root.left);
        root.left = invertTree2(root.right);
        root.right = tempRight;
        return root;
    }

    private void swap(TreeNode node) {
        if (node == null) {
            return ;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        swap(node.left);
        swap(node.right);
    }
}
