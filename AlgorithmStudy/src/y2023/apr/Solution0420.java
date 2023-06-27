package y2023.apr;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-width-of-binary-tree/
public class Solution0420 {
    public int widthOfBinaryTree(TreeNode root) {

        /*
            1            1
           2 3       2       3    3 - 1 + 1 => 2
          4 5 7    4    5  null  7  7 - 4 + 1 => 4
                 8   9 10 11 12 13 7 * 2 / 7 * 2 + 1

                 left = n * 2, right n * 2 + 1
         */

    //      1     <  1
    //    2,   3   < 2 <2, 3>
    // 4, 5 6, 7  < 4 <4,null,null,7>   -> 4
    //8       9   <   <8,9 > ?????


        int width = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();

            TreeNode left = queue.peek();
            TreeNode right = null;
            for(int i = 0 ; i < size; i++) {
                right = queue.poll();
                if (right.left != null) {
                    right.left.val = right.val * 2;
                    queue.offer(right.left);
                }

                if (right.right != null) {
                    right.right.val = right.val * 2 + 1;
                    queue.offer(right.right);
                }
            }

            width = Math.max(width, right.val - left.val + 1);
        }

        return width;
    }
}
