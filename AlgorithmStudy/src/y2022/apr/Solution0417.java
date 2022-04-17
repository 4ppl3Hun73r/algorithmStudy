package y2022.apr;

import model.TreeNode;

public class Solution0417 {

    TreeNode temp;

    public TreeNode increasingBST(TreeNode root) {

        TreeNode newRoot = new TreeNode();

        temp = newRoot;
        travel(root);

        return newRoot.right;
    }


    private void travel(TreeNode node) {
        if (node == null) {
            return ;
        }

        travel(node.left);
        temp.right = node;
        temp = temp.right;
        travel(node.right);
        node.left = null;
    }
}
