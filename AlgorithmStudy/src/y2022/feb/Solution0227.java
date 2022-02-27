package y2022.feb;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-width-of-binary-tree/
public class Solution0227 {
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.add(root);
        /*
                 1
             2       3
          4    5    6     7
        8 9 10 11 12 13 14 15
         */

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode start = queue.peek();
            TreeNode last = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.add(node.right);
                }
                last = node;
            }
            width = Math.max(width, last.val - start.val + 1);
        }

        return width;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 3000; i++) {
            System.out.print(1 + ",");
        }
    }
}
