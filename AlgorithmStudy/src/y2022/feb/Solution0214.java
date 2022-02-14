package y2022.feb;

import model.TreeNode;


// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class Solution0214 {
    // string -> parseInt
    // binary search
    //  while (left < right) {
    //      int mid = left / 2 + right / 2 + (left & right & 1) 3 3 -> 3 1 + 1 + 1
    //      int mid = min + (max - min) / 2; -> min < max
    //  }
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(maxDepth(node.left, depth + 1), maxDepth(node.right, depth + 1));
    }
}
