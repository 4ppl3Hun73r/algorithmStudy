package y2022.apr;

import model.TreeNode;
import y2021.aug.Codec;

// https://leetcode.com/problems/trim-a-binary-search-tree/
public class Solution0415 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        /*
        low <= tree <= high 값만 남기고 다른 node 를 다 제거
        trim?????
                ()
              ()  ()
                ()
         */
        //작은 범위로 한정짓고, 현재 상황만 본다

        return trim(root, low, high);
    }

    private TreeNode trim(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }

        if (node.val >= low && node.val <= high) {
            node.left = trim(node.left, low, high);
            node.right = trim(node.right, low, high);
            return node;
        }

        if (node.val < low) {
            return trim(node.right, low, high);
        }

        // node.val > high
        return trim(node.left, low, high);
    }

    public static void main(String[] args) throws Exception {
        Solution0415 s = new Solution0415();
        Codec c = new Codec();

        System.out.println(s.trimBST(c.deserialize("3,0,4,null,2,null,null,1"),1, 3));
    }
}
