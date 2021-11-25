package problems;

import model.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
              3
             / \
            9   20
               /  \
              15   7
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[20,9],[15,7]]
         */

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean zigzag = true; // true = <-, false = ->
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sub.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (zigzag) {
                Collections.reverse(sub);
            }

            zigzag = !zigzag;
            result.add(sub);
        }
        return result;
    }
}
