package y2021.oct;

import model.TreeNode;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class Solution1011 {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //result = Math.max(result, getMax(root.left) + getMax(root.right));
        int max = getMax(root);
        result = Math.max(result, max);

        return result;
    }

    private int getMax(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftDiameter = getMax(node.left) + 1;
        int rightDiameter = getMax(node.right) + 1;
        result = Math.max(result, leftDiameter + rightDiameter);

        return Math.max(leftDiameter, rightDiameter);
    }
}
