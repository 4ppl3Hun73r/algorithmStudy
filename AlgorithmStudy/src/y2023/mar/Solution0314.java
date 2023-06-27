package y2023.mar;

import model.TreeNode;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class Solution0314 {

    private int result = 0;
    public int sumNumbers(TreeNode root) {

        preOrder(root, 0);

        return result;
    }

    private void preOrder(TreeNode node, int value) {
        if (node == null) {
            return ;
        }

        value = (value * 10) + node.val;
        if (node.left == null && node.right == null) {
            result += value;
        }

        preOrder(node.left, value);
        preOrder(node.right, value);
    }
}
