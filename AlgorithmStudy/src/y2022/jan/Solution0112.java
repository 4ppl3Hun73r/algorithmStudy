package y2022.jan;

import model.TreeNode;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class Solution0112 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // BST 에서 위치 찾는 문제고
        // 완전 이진 트리도 아니어서 따로 정렬할 필요도 없고, 삽입만 하면 된다.
        if (root == null) {
            return new TreeNode(val);
        }

        helper(root, val);
        return root;
    }
    /*
            -> 5
                4
              2   *5*
            1  3     7

            -> 5
                 *5*
                4   7
              2
            1  3
     */

    private void helper(TreeNode node, int val) {
        /*
            -> 5
                4
              2   7
            1  3
         */

        if (node.val < val) {
            // 작으면 오른쪽 탐색
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                helper(node.right, val);
            }
        } else {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                helper(node.left, val);
            }
        }
    }

}
