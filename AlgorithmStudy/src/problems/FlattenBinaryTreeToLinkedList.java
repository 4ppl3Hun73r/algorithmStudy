package problems;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        preorder(root, nodes);
        TreeNode node = root;
        for (int i = 1; i < nodes.size(); i++) {
            node.left = null;
            node.right = nodes.get(i);
            node = nodes.get(i);
        }
    }

    private void preorder(TreeNode node, List<TreeNode> nodes) {
        if (node != null) {
            nodes.add(node);
            preorder(node.left, nodes);
            preorder(node.right, nodes);
        }
    }
}
