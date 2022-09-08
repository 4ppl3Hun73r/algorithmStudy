package y2022.sep;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class Solution0908 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        traversal(root, result);

        return result;
    }

    private void traversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return ;
        }
        traversal(node.left, result);
        result.add(node.val);
        traversal(node.right, result);
    }
}
