package nov;

import model.TreeNode;

// https://leetcode.com/problems/sum-of-left-leaves/
public class Solution1104 {

    int result;
    public int sumOfLeftLeaves(TreeNode root) {
        // 딱히 뭐 ...
        result = 0;

        left(root, false);

        return result;
    }

    public void left(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (isLeft && node.left == null && node.right == null) {
            result += node.val;
            return;
        }

        left(node.left, true);
        left(node.right, false);
    }
}
