package y2022.aug;

import model.TreeNode;

// https://leetcode.com/problems/validate-binary-search-tree/
public class Solution0811 {
    public boolean isValidBST(TreeNode root) {
        /*
            BST 인지 검증

            root 를 기준으로 왼쪽은 root보다 작아야 되고, 오른쪽은 root보다 커야함.

            MIN_VALUE <= node.val <= MAX_VALUE


                   5
                1     4
                    3   6

                   ^
                ?<   <?


                ^
             ?<   <5

         */
        // root.val => -2^31
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }



    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
