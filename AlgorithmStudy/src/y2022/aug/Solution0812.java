package y2022.aug;

import model.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class Solution0812 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        Given a binary search tree (BST), find the lowest common ancestor (LCA)
        node of two given nodes in the BST.

        According to the definition of LCA on Wikipedia:
        “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


                  6
            2          8
        0      4     7    9
              3  5

         */
        int left = Math.min(p.val, q.val);
        int right = Math.max(p.val, q.val);

        return helper(root, left, right);
    }

    private TreeNode helper(TreeNode node, int left, int right) {
        if (node == null) {
            return null;
        }
        int val = node.val;
        if (left <= val && val <= right) {
            return node;
        }

        //      6     [2,4]
        if (val > right) {
           return helper(node.left, left, right);
        }

        // val < left
        return helper(node.right, left, right);
    }
}
