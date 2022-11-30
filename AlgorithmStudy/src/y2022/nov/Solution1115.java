package y2022.nov;

import model.TreeNode;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class Solution1115 {
    public int countNodes(TreeNode root) {
        // Design an algorithm that runs in less than O(n) time complexity.

        /*

        h
        1 -> 1
        2 -> 3
        3 -> 7
        4 ->

              1
            2   3
           4       O(N)


         */

        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
