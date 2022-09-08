package y2022.sep;

import model.TreeNode;

public class Solution0906 {

    public TreeNode pruneTree(TreeNode root) {

        return findOne(root) ? root : null;
    }

    boolean findOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean left = findOne(node.left);
        boolean right = findOne(node.right);

        if (left == false) {
            node.left = null;
        }
        if (right == false) {
            node.right = null;
        }

        return node.val == 1 || left || right;
    }

}
