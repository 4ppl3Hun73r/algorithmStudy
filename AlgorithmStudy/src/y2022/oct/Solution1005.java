package y2022.oct;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/add-one-row-to-tree/
public class Solution1005 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        /*
        val node 를 depth 에 추가

         */
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (depth != 2) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth--;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }

        return root;
    }
}
