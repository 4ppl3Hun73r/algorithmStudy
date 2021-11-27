package problems;

import model.TreeNode;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInABST {
    int count;
    public int kthSmallest(TreeNode root, int k) {

        // inorder travel (Left, Root, Right)
        //

        // left < root < right
        // k th samllest -> inorder travel k th
        count = k;

        return inorder(root);
    }

    private Integer inorder(TreeNode node) {
        if (node.left != null) {
            Integer v = inorder(node.left);
            if (v != null) {
                return v;
            }
        }
        count--;
        if (count == 0) {
            return node.val;
        }
        if (node.right != null) {
            Integer v = inorder(node.right);
            if (v != null) {
                return v;
            }
        }
        return null;
    }

}
