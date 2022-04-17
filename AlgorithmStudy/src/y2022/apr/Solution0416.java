package y2022.apr;

import model.TreeNode;

// https://leetcode.com/problems/convert-bst-to-greater-tree/
public class Solution0416 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        /*
            오른쪽 끝부터 더해 나가야함

                4
              1   6
            0   2
         */

        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }


        return root;
    }


}
